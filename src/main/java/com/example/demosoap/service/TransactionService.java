package com.example.demosoap.service;

import java.util.List;

import com.example.demosoap.model.TransactionModel;

public interface TransactionService {
    boolean validateTransaction(TransactionModel transaction);
    TransactionModel executeTransaction(TransactionModel transaction);
    List<TransactionModel> getTransactionsByAccount(Long accountId);
    TransactionModel findById(Long id);
}