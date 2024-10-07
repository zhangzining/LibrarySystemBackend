package com.zzn.librarysystem.userModule.domain;

import com.zzn.librarysystem.common.enums.AdminUserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Table(schema = "admin_user")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
     * User status
     */
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private AdminUserStatus status;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "admin_user_role_rel",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<AdminRole> roles;

}
