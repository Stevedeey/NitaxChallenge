package com.example.nitaxcodingchallenge.payload.request;

import com.example.nitaxcodingchallenge.payload.response.AccountResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfoRequest {

    private int responseCode;

    private boolean success;

    private String message;

    private AccountResponse accountResponse;
}
