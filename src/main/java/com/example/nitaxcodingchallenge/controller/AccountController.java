package com.example.nitaxcodingchallenge.controller;


import com.example.nitaxcodingchallenge.payload.request.CreateAccountRequest;
import com.example.nitaxcodingchallenge.payload.request.DepositRequest;
import com.example.nitaxcodingchallenge.payload.request.WithdrawalRequest;
import com.example.nitaxcodingchallenge.payload.response.AccountInfoResponse;
import com.example.nitaxcodingchallenge.payload.response.CreateAccountResponse;
import com.example.nitaxcodingchallenge.payload.response.DepositResponse;
import com.example.nitaxcodingchallenge.service.AccountService;
import com.example.nitaxcodingchallenge.transaction.TransactionHistory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/account")
@Slf4j
public class AccountController {
    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }


    @GetMapping(path = "/info/{accountNumber}")
    public ResponseEntity<AccountInfoResponse> getAccountInfo(@PathVariable String accountNumber) {
        log.info(">>>i got in getAccountIfo Controller");

        return service.getAccountInfo(accountNumber);
    }

    @GetMapping(path = "/statement/{accountNumber}")
    public ResponseEntity<TransactionHistory> getTransactionHistory(@PathVariable String accountNumber) {
        return service.getTransactionHistory(accountNumber);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody CreateAccountRequest request) {

        var account = service.createAccount(request);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping(path = "/withdraw")
    public ResponseEntity<?> doWithdrawal(@RequestBody WithdrawalRequest request) {

        var withdrawal = service.withdraw(request);

        if (withdrawal.isSuccess() == false) return new ResponseEntity<>(withdrawal, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(withdrawal, HttpStatus.OK);
    }

    @PostMapping(path = "/deposit")
    public ResponseEntity<DepositResponse> doDeposit(@RequestBody DepositRequest depositRequest) {

        return service.deposit(depositRequest);
    }

}
