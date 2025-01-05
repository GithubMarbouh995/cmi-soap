package com.example.demosoap.repository;

import com.example.demosoap.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {
    
    Optional<AccountModel> findByAccountNumber(String accountNumber);
    
    List<AccountModel> findByAccountHolder(String accountHolder);
    
    List<AccountModel> findByAccountType(String accountType);
    
    List<AccountModel> findByBalanceGreaterThan(Double balance);
    
    List<AccountModel> findByCurrency(String currency);
}