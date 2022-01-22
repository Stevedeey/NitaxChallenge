package com.example.nitaxcodingchallenge.payload.response;

import lombok.*;

import java.util.Date;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionHistoryResponse {

    private Date transactionDate;

    private String transactionType;

    private String narration;

    private Double amount;

    private Double accountBalance;
}
