package com.zzn.librarysystem.userModule.domain;

import com.zzn.librarysystem.common.enums.NormalUserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(schema = "normal_user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NormalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * User name for login
     */
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    /**
     * User password for login
     */
    @Column(nullable = false, unique = true, length = 500)
    private String password;

    /**
     * Password salt for login
     */
    @Column(nullable = false, length = 16)
    private String salt;

    /**
     * User nickname for identify himself
     */
    @Column(nullable = false, unique = true, length = 200)
    private String nickname;

    /**
     * User status
     */
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private NormalUserStatus status;

}
