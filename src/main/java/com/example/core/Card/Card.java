package com.example.core.Card;

import com.example.core.Account.Account;


import java.util.ArrayList;
import java.util.List;

public class Card {

    private int pin;
    private List<Account> accountList;

    public Card(int pin){
        this.pin = pin;
        accountList = new ArrayList<>();
    }

    public int getPin() {
        return pin;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void addAccount(Account account){
        accountList.add(account);
    }


}
