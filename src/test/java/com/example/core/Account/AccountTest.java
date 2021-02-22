package com.example.core.Account;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AccountTest {

    @Test
    void deposit() {
        Account ac = new Account("main", Account_Type.CHECKING, 8206124892L,10000);
        ac.deposit(1000);
        assertThat(ac.checkBalance()).isEqualTo(11000);
    }

    @Test
    void withdraw() {
        Account ac = new Account("secondary", Account_Type.SAVINGS,8206124972L, 10000);
        ac.withdraw(1000);
        assertThat(ac.checkBalance()).isEqualTo(9000);
    }

    @Test
    void transfer() {
        Account ac1 = new Account("main", Account_Type.CHECKING, 8206124892L,10000);
        Account ac2 = new Account("secondary", Account_Type.SAVINGS,8206124972L, 10000);
        ac1.transferTo(ac2, 1000);
        assertThat(ac1.checkBalance()).isEqualTo(9000);
        assertThat(ac2.checkBalance()).isEqualTo(11000);
    }
}