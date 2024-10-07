package com.zzn.librarysystem.userModule.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDto {
    private String token;
    private String refreshToken;
    private String message;
}
