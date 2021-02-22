package com.example.core.ATMController;

import com.example.core.Account.Account;
import com.example.core.Card.Card;

public interface ATMController {

    void insertCard(Card c);
    void ejectCard();
    void enterPinNum(int input);
    void selectAcocunt(Account account);

    void withdraw(long amount);
    void deposit(long amount);
    void transferTo(Account destination, long amount);

    Card getCard();
}
