package com.example.core.ATMController;

public enum State {
    INITIAL, // card ejected
    CORRECT_PIN,
    SELECT_ACCOUNT,
    SELECT_TRANSACTION, // correct pin inserted
    DEPOSIT,
    WITHDRAWAL,
    BALANCE_INQUIRY,
    CARD_EJECTED,
}
