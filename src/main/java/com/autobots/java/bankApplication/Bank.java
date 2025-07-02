package com.autobots.java.bankApplication;

public interface Bank {

    //пополнение
    void deposit(double amount);

    void withDraw(double amount);
    //списание с баланса


    static void transferFunds(Bank sender, Bank recipient, double transferAmount) {
        sender.withDraw(transferAmount);
        recipient.deposit(transferAmount);
    }
}

