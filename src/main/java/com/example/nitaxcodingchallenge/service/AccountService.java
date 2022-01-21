package com.example.nitaxcodingchallenge.service;

import com.example.nitaxcodingchallenge.payload.auth.LoginRequest;
import com.example.nitaxcodingchallenge.payload.auth.LoginResponse;

public interface AccountService {
    LoginResponse login(LoginRequest loginRequest);
}
