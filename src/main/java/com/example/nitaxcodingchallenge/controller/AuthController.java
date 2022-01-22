package com.example.nitaxcodingchallenge.controller;


import com.example.nitaxcodingchallenge.payload.auth.LoginRequest;
import com.example.nitaxcodingchallenge.payload.auth.LoginResponse;
import com.example.nitaxcodingchallenge.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final AccountService accountService;

    public AuthController(AuthenticationManager authenticationManager, AccountService accountService) {
        this.authenticationManager = authenticationManager;
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> doLogin(@RequestBody LoginRequest loginRequest) {

        return new ResponseEntity<>(accountService.login(loginRequest), HttpStatus.OK);
    }
}
