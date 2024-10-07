package com.zzn.librarysystem.userModule.controller;

import com.zzn.librarysystem.userModule.model.AuthRequestDto;
import com.zzn.librarysystem.userModule.model.AuthResponseDto;
import com.zzn.librarysystem.userModule.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
    }
}
