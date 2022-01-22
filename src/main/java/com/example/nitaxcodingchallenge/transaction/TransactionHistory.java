package com.example.nitaxcodingchallenge.transaction;

import com.example.nitaxcodingchallenge.payload.response.TransactionHistoryResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionHistory {

    private List<TransactionHistoryResponse> transactionHistoryList;

    public List<TransactionHistoryResponse> getTransactionHistoryList() {
        return transactionHistoryList;
    }

    public void setTransactionHistoryList(List<TransactionHistoryResponse> transactionHistoryList) {
        this.transactionHistoryList = transactionHistoryList;
    }
}
