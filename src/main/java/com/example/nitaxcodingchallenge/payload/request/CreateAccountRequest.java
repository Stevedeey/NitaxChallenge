package com.example.nitaxcodingchallenge.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@ToString
public class CreateAccountRequest {

    @NotNull(message = "Account name cannot be empty")
    private String accountName;

    @NotNull(message = "You need to choose a password")
    private String accountPassword;

    @NotNull(message = "Initial deposit cannot be empty")
    private Double initialDeposit;

    public CreateAccountRequest() {
        initialDeposit = 0.0;
    }
}
