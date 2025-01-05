package com.example.demosoap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;




@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String transactionNumber;
    
    @Column(nullable = false)
    private Double amount;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    
    @Column(nullable = false)
    private TransactionStatus status;
    
    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private AccountModel sourceAccount;
    
    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private AccountModel destinationAccount;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    

    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        transactionNumber = "TXN" + System.currentTimeMillis();
    }
}

