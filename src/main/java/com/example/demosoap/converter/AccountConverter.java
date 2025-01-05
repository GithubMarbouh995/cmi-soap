package com.example.demosoap.converter;

import com.example.demosoap.gen.Account;
import com.example.demosoap.model.AccountModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountConverter {

    public AccountModel convertAccountToAccountModel(Account account) {
        AccountModel accountModel = new AccountModel();
        accountModel.setId(account.getId());
        accountModel.setAccountNumber(account.getAccountNumber());
        accountModel.setAccountHolder(account.getAccountHolder());
        accountModel.setBalance(account.getBalance());
        accountModel.setAccountType(account.getAccountType());
        accountModel.setCurrency(account.getCurrency());
        return accountModel;
    }

    public Account convertAccountModelToAccount(AccountModel accountModel) {
        Account account = new Account();
        account.setId(accountModel.getId());
        account.setAccountNumber(accountModel.getAccountNumber());
        account.setAccountHolder(accountModel.getAccountHolder());
        account.setBalance(accountModel.getBalance());
        account.setAccountType(accountModel.getAccountType());
        account.setCurrency(accountModel.getCurrency());
        return account;
    }

    public List<AccountModel> convertAccountsToAccountModels(List<Account> accounts) {
        List<AccountModel> accountModels = new ArrayList<>();
        for (Account account : accounts) {
            accountModels.add(convertAccountToAccountModel(account));
        }
        return accountModels;
    }

    public List<Account> convertAccountModelsToAccounts(List<AccountModel> accountModels) {
        List<Account> accounts = new ArrayList<>();
        for (AccountModel accountModel : accountModels) {
            accounts.add(convertAccountModelToAccount(accountModel));
        }
        return accounts;
    }
}