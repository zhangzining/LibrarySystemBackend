package com.zzn.librarysystem.userModule.service;


import com.zzn.librarysystem.userModule.domain.NormalUser;
import com.zzn.librarysystem.userModule.mapper.UserMapper;
import com.zzn.librarysystem.userModule.model.AuthRequestDto;
import com.zzn.librarysystem.userModule.model.AuthResponseDto;
import com.zzn.librarysystem.userModule.repository.NormalUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final NormalUserRepository normalUserRepository;

    private final UserMapper userMapper;

    public AuthResponseDto login(AuthRequestDto requestDto) {
        NormalUser normalUser = normalUserRepository.findByUsername(requestDto.getUsername()).get();
        log.debug(normalUser.toString());
        return AuthResponseDto.builder()
                .token("token")
                .build();
    }
}
