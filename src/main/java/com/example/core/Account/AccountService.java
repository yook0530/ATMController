package com.example.core.Account;

public interface AccountService {

    long checkBalance();
    long deposit(long amount);
    long withdraw(long amount);
    void transferTo(Account ac, long amount);

}
