package com.example.demosoap.endpoint;

import com.example.demosoap.converter.AccountConverter;
import com.example.demosoap.gen.*;
import com.example.demosoap.model.AccountModel;
import com.example.demosoap.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class AccountEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/gen";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountConverter accountConverter;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountsRequest")
    @ResponsePayload
    public GetAccountsResponse getAccounts(@RequestPayload GetAccountsRequest request) {
        GetAccountsResponse response = new GetAccountsResponse();
        List<AccountModel> accountModels = accountRepository.findAll();
        response.getAccounts().addAll(accountConverter.convertAccountModelsToAccounts(accountModels));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccount(@RequestPayload GetAccountRequest request) {
        GetAccountResponse response = new GetAccountResponse();
        AccountModel accountModel = accountRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        response.setAccount(accountConverter.convertAccountModelToAccount(accountModel));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createAccountRequest")
    @ResponsePayload
    public CreateAccountResponse createAccount(@RequestPayload CreateAccountRequest request) {
        CreateAccountResponse response = new CreateAccountResponse();
        AccountModel accountModel = accountConverter.convertAccountToAccountModel(request.getAccount());
        AccountModel savedAccount = accountRepository.save(accountModel);
        response.setAccount(accountConverter.convertAccountModelToAccount(savedAccount));
        return response;
    }
}