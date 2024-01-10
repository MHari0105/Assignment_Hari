package com.backend.CrudApp.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    
    private String token;
    private String refreshToken;
}
