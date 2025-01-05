package com.example.demosoap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demosoap.model.AccountModel;
import com.example.demosoap.model.TransactionModel;
import com.example.demosoap.model.TransactionStatus;
import com.example.demosoap.repository.AccountRepository;
import com.example.demosoap.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Override
    public boolean validateTransaction(TransactionModel transaction) {
        if (transaction.getAmount() <= 0) {
            return false;
        }
        
        switch (transaction.getType()) {
            case TRANSFER:
                return validateTransfer(transaction);
            case WITHDRAWAL:
                return validateWithdrawal(transaction);
            case DEPOSIT:
                return validateDeposit(transaction);
            default:
                return false;
        }
    }
    
    private boolean validateTransfer(TransactionModel transaction) {
        return transaction.getSourceAccount() != null 
            && transaction.getDestinationAccount() != null 
            && transaction.getSourceAccount().getBalance() >= transaction.getAmount();
    }
    
    private boolean validateWithdrawal(TransactionModel transaction) {
        return transaction.getSourceAccount() != null 
            && transaction.getSourceAccount().getBalance() >= transaction.getAmount();
    }
    
    private boolean validateDeposit(TransactionModel transaction) {
        return transaction.getDestinationAccount() != null;
    }
    
    @Override
    public TransactionModel executeTransaction(TransactionModel transaction) {
        if (!validateTransaction(transaction)) {
            transaction.setStatus(TransactionStatus.FAILED);
            return transactionRepository.save(transaction);
        }
        
        try {
            switch (transaction.getType()) {
                case TRANSFER:
                    executeTransfer(transaction);
                    break;
                case WITHDRAWAL:
                    executeWithdrawal(transaction);
                    break;
                case DEPOSIT:
                    executeDeposit(transaction);
                    break;
            }
            transaction.setStatus(TransactionStatus.COMPLETED);
        } catch (Exception e) {
            transaction.setStatus(TransactionStatus.FAILED);
        }
        
        return transactionRepository.save(transaction);
    }
    
    private void executeTransfer(TransactionModel transaction) {
        AccountModel source = transaction.getSourceAccount();
        AccountModel destination = transaction.getDestinationAccount();
        
        source.setBalance(source.getBalance() - transaction.getAmount());
        destination.setBalance(destination.getBalance() + transaction.getAmount());
        
        accountRepository.save(source);
        accountRepository.save(destination);
    }
    
    private void executeWithdrawal(TransactionModel transaction) {
        AccountModel source = transaction.getSourceAccount();
        source.setBalance(source.getBalance() - transaction.getAmount());
        accountRepository.save(source);
    }
    
    private void executeDeposit(TransactionModel transaction) {
        AccountModel destination = transaction.getDestinationAccount();
        destination.setBalance(destination.getBalance() + transaction.getAmount());
        accountRepository.save(destination);
    }
    
    @Override
    public List<TransactionModel> getTransactionsByAccount(Long accountId) {
        return transactionRepository.findBySourceAccountIdOrDestinationAccountId(accountId, accountId);
    }

    @Override
    public TransactionModel findById(Long id) {
        return transactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    
}