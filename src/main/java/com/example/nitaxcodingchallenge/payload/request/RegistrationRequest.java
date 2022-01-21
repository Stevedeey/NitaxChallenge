package com.example.nitaxcodingchallenge.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    private String phoneNumber;

    private String referralPhoneNumber;

    private String fullName;

    private String role;


}
