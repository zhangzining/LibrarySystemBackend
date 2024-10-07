package com.zzn.librarysystem.userModule.security;

import com.zzn.librarysystem.common.enums.UserType;
import com.zzn.librarysystem.userModule.domain.AdminUser;
import com.zzn.librarysystem.userModule.domain.NormalUser;
import com.zzn.librarysystem.userModule.repository.AdminUserRepository;
import com.zzn.librarysystem.userModule.repository.NormalUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final NormalUserRepository normalUserRepository;
    private final AdminUserRepository adminUserRepository;

    @Override
    public UserDetails loadUserByUsername(String tokenSubject) throws UsernameNotFoundException {
        UserType type = UserIdentifierParser.getUserType(tokenSubject);
        return switch (type) {
            case ADMIN_USER -> findAdminUserByUsername(tokenSubject);
            case NORMAL_USER -> findNormalUserByUsername(tokenSubject);
        };
    }

    private UserDetails findNormalUserByUsername(String tokenSubject) {
        Long userId = UserIdentifierParser.getNormalUserId(tokenSubject);
        NormalUser normalUser = normalUserRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Normal user not exists: " + userId));
        return new User(normalUser.getUsername(), normalUser.getPassword(), List.of());
    }

    private UserDetails findAdminUserByUsername(String tokenSubject) {
        Long userId = UserIdentifierParser.getAdminUserId(tokenSubject);
        AdminUser adminUser = adminUserRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Admin user not exists: " + userId));

        Set<GrantedAuthority> authorities = adminUser.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new User(adminUser.getUsername(), adminUser.getPassword(), List.of());
    }
}
