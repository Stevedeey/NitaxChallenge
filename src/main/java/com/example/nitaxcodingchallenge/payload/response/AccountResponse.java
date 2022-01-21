package com.example.nitaxcodingchallenge.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private String accountName;

    private String accountNumber;

    private Double balance;
}
