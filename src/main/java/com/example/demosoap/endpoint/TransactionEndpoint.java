package com.example.demosoap.endpoint;

import com.example.demosoap.converter.TransactionConverter;
import com.example.demosoap.gen.*;
import com.example.demosoap.model.TransactionModel;
import com.example.demosoap.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class TransactionEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/gen";

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionConverter transactionConverter;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createTransactionRequest")
    @ResponsePayload
    public CreateTransactionResponse createTransaction(@RequestPayload CreateTransactionRequest request) {
        CreateTransactionResponse response = new CreateTransactionResponse();
        TransactionModel transactionModel = transactionConverter.convertTransactionToTransactionModel(request.getTransaction());
        
        boolean isValid = transactionService.validateTransaction(transactionModel);
        if (!isValid) {
            response.setStatus(com.example.demosoap.gen.TransactionStatus.FAILED);
            response.setMessage("Transaction invalide");
            return response;
        }

        TransactionModel executedTransaction = transactionService.executeTransaction(transactionModel);
        response.setTransaction(transactionConverter.convertTransactionModelToTransaction(executedTransaction));
        response.setStatus(convertStatus(executedTransaction.getStatus()));
        return response;
    }

    private com.example.demosoap.gen.TransactionStatus convertStatus(com.example.demosoap.model.TransactionStatus status) {
        return com.example.demosoap.gen.TransactionStatus.valueOf(status.name());
    }
}