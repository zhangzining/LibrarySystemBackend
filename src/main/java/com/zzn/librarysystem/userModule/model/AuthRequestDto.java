package com.zzn.librarysystem.userModule.model;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String username;
    private String password;
}
