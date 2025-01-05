package com.example.demosoap.repository;

import com.example.demosoap.model.TransactionModel;
import com.example.demosoap.model.TransactionStatus;
import com.example.demosoap.model.TransactionType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
    
    List<TransactionModel> findBySourceAccountIdOrDestinationAccountId(Long sourceId, Long destinationId);
    
    List<TransactionModel> findBySourceAccountId(Long accountId);
    
    List<TransactionModel> findByDestinationAccountId(Long accountId);
    
    List<TransactionModel> findByStatus(TransactionStatus status);
    
    List<TransactionModel> findByType(TransactionType type);
}