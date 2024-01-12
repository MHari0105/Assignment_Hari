package com.backend.CrudApp.service.impl;

import com.backend.CrudApp.dto.JwtAuthenticationResponse;
import com.backend.CrudApp.dto.RefreshTokenRequests;
import com.backend.CrudApp.dto.SigninRequest;
import com.backend.CrudApp.dto.SignupRequest;
import com.backend.CrudApp.entity.Role;
import com.backend.CrudApp.entity.User;
import com.backend.CrudApp.repository.UserRepository;
import com.backend.CrudApp.service.AuthenticationService;
import com.backend.CrudApp.service.JwtService;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepo;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authManager;

    private final JwtService jwtService;

    public User signup(SignupRequest signupRequest) {
        User user = new User();

        user.setEmail(signupRequest.getEmail());
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

        return userRepo.save(user);
    }

    public JwtAuthenticationResponse signin(SigninRequest siginReq) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(siginReq.getEmail(), siginReq.getPassword()));

        var user = userRepo.findByEmail(siginReq.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthRes = new JwtAuthenticationResponse();
        jwtAuthRes.setToken(jwt);
        jwtAuthRes.setRefreshToken(refreshToken);

        return jwtAuthRes;
    }

    public JwtAuthenticationResponse refreshToken(RefreshTokenRequests refreshTokenReq) {
        String userEmail = jwtService.extractUserName(refreshTokenReq.getToken());
        User user = userRepo.findByEmail(userEmail).orElseThrow();

        if (jwtService.isTokenValid(refreshTokenReq.getToken(), user)) {
            var jwt = jwtService.generateToken(user);

            JwtAuthenticationResponse jwtAuthRes = new JwtAuthenticationResponse();
            jwtAuthRes.setToken(jwt);
            jwtAuthRes.setRefreshToken(refreshTokenReq.getToken());

            return jwtAuthRes;
        }

        return null;
    }

}
