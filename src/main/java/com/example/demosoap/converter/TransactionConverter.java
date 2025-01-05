package com.example.demosoap.converter;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demosoap.model.TransactionModel;
import com.example.demosoap.gen.Transaction;
import com.example.demosoap.repository.AccountRepository;
import com.example.demosoap.model.TransactionType;
import com.example.demosoap.model.TransactionStatus;
import java.util.List;


@Component
public class TransactionConverter {

    @Autowired
    private AccountRepository accountRepository;

    public Transaction convertTransactionModelToTransaction(TransactionModel transactionModel) {
        if (transactionModel == null) return null;

        Transaction transaction = new Transaction();
        transaction.setId(transactionModel.getId());
        transaction.setTransactionNumber(transactionModel.getTransactionNumber());
        transaction.setAmount(transactionModel.getAmount());
        
        // Conversion des enums
        transaction.setType(com.example.demosoap.gen.TransactionType.valueOf(transactionModel.getType().name()));
        transaction.setStatus(com.example.demosoap.gen.TransactionStatus.valueOf(transactionModel.getStatus().name()));
        
        if (transactionModel.getSourceAccount() != null) {
            transaction.setSourceAccountId(transactionModel.getSourceAccount().getId());
        }
        
        if (transactionModel.getDestinationAccount() != null) {
            transaction.setDestinationAccountId(transactionModel.getDestinationAccount().getId());
        }

        return transaction;
    }

    public TransactionModel convertTransactionToTransactionModel(Transaction transaction) {
        if (transaction == null) return null;

        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setTransactionNumber(transaction.getTransactionNumber());
        transactionModel.setAmount(transaction.getAmount());
        
        // Conversion des enums
        transactionModel.setType(TransactionType.valueOf(transaction.getType().name()));
        transactionModel.setStatus(TransactionStatus.valueOf(transaction.getStatus().name()));
        
        if (transaction.getSourceAccountId() != null) {
            transactionModel.setSourceAccount(
                accountRepository.findById(transaction.getSourceAccountId()).orElse(null)
            );
        }
        
        if (transaction.getDestinationAccountId() != null) {
            transactionModel.setDestinationAccount(
                accountRepository.findById(transaction.getDestinationAccountId()).orElse(null)
            );
        }

        return transactionModel;
    }
    public List<Transaction> convertTransactionModelsToTransactions(List<TransactionModel> models) {
        if (models == null) return new ArrayList<>();
        return models.stream()
            .map(this::convertTransactionModelToTransaction)
            .collect(Collectors.toList());
    }
}