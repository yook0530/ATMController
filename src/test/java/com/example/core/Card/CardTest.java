package com.example.core.Card;

import com.example.core.Account.Account;
import com.example.core.Account.Account_Type;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void addAccount() {
        Card card = new Card(1435);
        Account checking = new Account("checking", Account_Type.CHECKING, 9023194051924L, 1000);
        Account savings = new Account("savings", Account_Type.SAVINGS, 16344511924L, 10000);
        Account credit = new Account("credit", Account_Type.CREDIT, 9023194051924L, 5142);
        card.addAccount(checking);
        card.addAccount(savings);
        card.addAccount(credit);

        Assertions.assertThat(card.getAccountList().size()).isEqualTo(3);
    }
}