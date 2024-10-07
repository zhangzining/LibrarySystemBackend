package com.zzn.librarysystem.userModule.repository;

import com.zzn.librarysystem.userModule.domain.NormalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NormalUserRepository extends JpaRepository<NormalUser, Long> {

    Optional<NormalUser> findByUsername(String username);

}
