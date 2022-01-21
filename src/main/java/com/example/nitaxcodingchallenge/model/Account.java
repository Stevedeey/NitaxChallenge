package com.example.nitaxcodingchallenge.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Account {

    private String accountName;

    private  String accountNumber;

    private  String password;

    private Double balance;
}
