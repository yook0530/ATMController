package com.example.core.ATMController;

import com.example.core.Account.Account;
import com.example.core.Account.Account_Type;
import com.example.core.AppConfig;
import com.example.core.Card.Card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;

import static org.assertj.core.api.Assertions.*;

class ATMControllerImplTest {

    ATMController ATM;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        ATM = appConfig.atmController();
    }

    @Test
    void insertCard() {
        Card card = new Card(1475);
        ATM.insertCard(card);
        assertThat(ATM.getCard()).isEqualTo(card);
    }

    @Test
    void ejectCard() {
        Card card = new Card(1535);
        ATM.insertCard(card);
        ATM.ejectCard();
        assertThat(ATM.getCard()).isEqualTo(null);
    }

    @Test
    void enterPinNum() {
        Card card = new Card(7942);
        card.addAccount(new Account("gunny", Account_Type.CHECKING, 7506124892L, 1000));
        card.addAccount(new Account("danny", Account_Type.SAVINGS, 526124892L, 2000));
        ATM.insertCard(card);
        assertThat(((ATMControllerImpl) ATM).getAccountList()).isEqualTo(null);
        ATM.enterPinNum(7942);
        assertThat(((ATMControllerImpl) ATM).getAccountList()).isEqualTo(card.getAccountList());
    }


    @Test
    void selectAccount() {
        Card card = new Card(1535);
        Account gunny = new Account("gunny", Account_Type.CHECKING, 7506124892L, 1000);
        card.addAccount(gunny);
        Account danny = new Account("danny", Account_Type.SAVINGS, 526124892L, 2000);
        card.addAccount(danny);
        ATM.insertCard(card);
        ATM.enterPinNum(1535);
        ATM.selectAcocunt(danny);
        assertThat(((ATMControllerImpl) ATM).getAccount()).isEqualTo(danny);
//        ATM.ejectCard();
    }

    @Test
    void withdraw() {
        Card card = new Card(2790);
        Account gunny = new Account("credit", Account_Type.CREDIT, 903524892L, 10000);
        card.addAccount(gunny);
        ATM.insertCard(card);
        ATM.enterPinNum(2790);
        ATM.selectAcocunt(gunny);
        ATM.withdraw(1000);
        assertThat(((ATMControllerImpl) ATM).getAccount().checkBalance()).isEqualTo(9000);
//        ATM.ejectCard();

    }

    @Test
    void deposit() {
        Card card = new Card(2790);
        Account gunny = new Account("credit", Account_Type.CREDIT, 903524892L, 10000);
        card.addAccount(gunny);
        ATM.insertCard(card);
        ATM.enterPinNum(2790);
        ATM.selectAcocunt(gunny);
        ATM.deposit(2000);
        assertThat(((ATMControllerImpl) ATM).getAccount().checkBalance()).isEqualTo(12000);
    }

    @Test
    void transferTo() {
        Card card = new Card(2790);
        Account savings = new Account("savings", Account_Type.SAVINGS, 903524892L, 10000);
        card.addAccount(savings);
        Account checking = new Account("checking", Account_Type.SAVINGS, 903524892L, 10000);
        ATM.insertCard(card);
        ATM.enterPinNum(2790);
        ATM.selectAcocunt(savings);
        ATM.transferTo(checking, 1000);
        assertThat(((ATMControllerImpl) ATM).getAccount().checkBalance()).isEqualTo(9000);
        assertThat(checking.checkBalance()).isEqualTo(11000);
    }


}