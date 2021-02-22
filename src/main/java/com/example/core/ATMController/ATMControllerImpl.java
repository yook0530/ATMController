package com.example.core.ATMController;

import com.example.core.Account.Account;
import com.example.core.Card.Card;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ATMControllerImpl implements ATMController {
    public List<Account> getAccountList() {
        return accountList;
    }

    private Card card;
    private Account account;
    private List<Account> accountList;
    private boolean inserted;
    State state;

    public Card getCard() {
        return card;
    }

    public Account getAccount() {
        return account;
    }

    public ATMControllerImpl() {
        this.inserted = false;
        this.card = null;
        this.accountList = null;
        this.state = State.INITIAL;
    }

    @Override
    public void insertCard(Card c) {
        if (!inserted) {
            card = c;
            inserted = true;
            return;
        }
        System.out.println("Card already inserted");
    }

    @Override
    public void ejectCard() {
        if (inserted) {
            card = null;
            inserted = false;
            accountList = null;
            account = null;
            return;
        }
        System.out.println("No card to eject");
    }

    @Override
    public void enterPinNum(int input) {
        if (card.getPin() == input) {
            accountList = card.getAccountList();
            state = State.CORRECT_PIN;
            return;
        }
    }

    @Override
    public void selectAcocunt(Account ac){
        if(accountList.contains(ac))
            this.account = ac;
    }

    @Override
    public void withdraw(long amount) {
        account.withdraw(amount);
    }

    @Override
    public void deposit(long amount) {
        account.deposit(amount);
    }

    @Override
    public void transferTo(Account destination, long amount) {
        account.withdraw(amount);
        destination.deposit(amount);
    }


}
