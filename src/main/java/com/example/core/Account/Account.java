package com.example.core.Account;

public class Account {

    private String name;
    private Account_Type type;
    private long accountNumber;
    private long balance;

    public Account(String name, Account_Type type, long accountNumber, long balance){
        this.name = name;
        this.type = type;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long checkBalance(){
        return balance;
    }

    public long deposit(long amount){
        if(amount > 0){
            balance += amount;
        }
        return balance;
    }

    public void withdraw(long amount){
        if((amount > balance || amount <= 0) && type != Account_Type.CREDIT){
            System.out.println("You cannot withdraw more than balance");
            return;
        }
        balance -= amount;
        return;
    }

    private long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() { return name; }

    public Account_Type getType() {
        return type;
    }

    void transferTo(Account destination, long amount) {
        if(amount > 0) {
            this.withdraw(amount);
            destination.deposit(amount);
            return;
        }
        System.out.println("Invalid value");
    }

    public void displayAccountInfo() {
        System.out.println("Account name: " + getAccountName());
        System.out.println("Type: " + getType());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Current Balance: " + checkBalance());
    }
}
