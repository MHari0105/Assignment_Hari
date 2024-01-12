package com.backend.CrudApp.service;

import com.backend.CrudApp.dto.JwtAuthenticationResponse;
import com.backend.CrudApp.dto.RefreshTokenRequests;
import com.backend.CrudApp.dto.SigninRequest;
import com.backend.CrudApp.dto.SignupRequest;
import com.backend.CrudApp.entity.User;

public interface AuthenticationService {

    public User signup(SignupRequest signupRequest);
    JwtAuthenticationResponse signin(SigninRequest siginReq);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequests refreshTokenReq);
}
