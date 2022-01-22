package com.example.nitaxcodingchallenge.service.DaoLayer;

import com.example.nitaxcodingchallenge.payload.response.TransactionHistoryResponse;
import com.example.nitaxcodingchallenge.transaction.TransactionDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class AccountHistoryDaoImpl implements AccountHistoryDao<TransactionDetail, Map>{

    private Map<String, List<TransactionHistoryResponse>> accountHistoryMap = new HashMap<>();

    @Override
    public TransactionDetail save(TransactionDetail transactionDetail) {

        TransactionHistoryResponse transactionHistoryResponse = TransactionHistoryResponse
                                                                .builder()
                .accountBalance(transactionDetail.getAccountBalance())
                .transactionDate(transactionDetail.getTransactionDate())
                .transactionType(transactionDetail.getTransactionType())
                .amount(transactionDetail.getAmount())
                .narration(transactionDetail.getNarration())
                .build();

       if(accountHistoryMap.containsKey(transactionDetail.getAccountNumber())){
           List<TransactionHistoryResponse> infoList = accountHistoryMap.get(transactionDetail.getAccountNumber());
           infoList.add(transactionHistoryResponse);

           accountHistoryMap.put(transactionDetail.getAccountNumber(), infoList);
       }else {
           List<TransactionHistoryResponse> transactionHistoryResponseList = new ArrayList<>();
           transactionHistoryResponseList.add(transactionHistoryResponse);

           accountHistoryMap.put(transactionDetail.getAccountNumber(), transactionHistoryResponseList);
       }

        return transactionDetail;
    }

    public List<TransactionHistoryResponse> getAccountHistory (String accountNumber){
        log.info(":::Account History Map{}",accountHistoryMap.get(accountNumber));
        return accountHistoryMap.get(accountNumber) != null ? accountHistoryMap.get(accountNumber) : new ArrayList<>();
    }
}
