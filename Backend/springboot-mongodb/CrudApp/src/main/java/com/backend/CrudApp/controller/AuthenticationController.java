package com.backend.CrudApp.controller;

import com.backend.CrudApp.dto.JwtAuthenticationResponse;
import com.backend.CrudApp.dto.SigninRequest;
import com.backend.CrudApp.dto.SignupRequest;
import com.backend.CrudApp.entity.User;
import com.backend.CrudApp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupRequest signupReq) {
        return ResponseEntity.ok(authService.signup(signupReq));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinReq) {
        return ResponseEntity.ok(authService.signin(signinReq));
    }

}
