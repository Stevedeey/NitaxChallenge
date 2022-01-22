package com.example.nitaxcodingchallenge.service;

import com.example.nitaxcodingchallenge.model.Account;
import com.example.nitaxcodingchallenge.payload.auth.LoginRequest;
import com.example.nitaxcodingchallenge.payload.auth.LoginResponse;
import com.example.nitaxcodingchallenge.payload.request.CreateAccountRequest;
import com.example.nitaxcodingchallenge.payload.request.DepositRequest;
import com.example.nitaxcodingchallenge.payload.request.WithdrawalRequest;
import com.example.nitaxcodingchallenge.payload.response.AccountInfoResponse;
import com.example.nitaxcodingchallenge.payload.response.CreateAccountResponse;
import com.example.nitaxcodingchallenge.payload.response.DepositResponse;
import com.example.nitaxcodingchallenge.payload.response.WithdrawalResponse;
import com.example.nitaxcodingchallenge.transaction.TransactionHistory;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface AccountService {
    LoginResponse login(LoginRequest loginRequest);

    Map<String, Account> getAccountMap();

    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);

    WithdrawalResponse withdraw(WithdrawalRequest request);

    ResponseEntity<DepositResponse> deposit(DepositRequest depositRequest);

    ResponseEntity<AccountInfoResponse> getAccountInfo(String accountNumber);

    ResponseEntity<TransactionHistory> getTransactionHistory(String accountNumber);

}
