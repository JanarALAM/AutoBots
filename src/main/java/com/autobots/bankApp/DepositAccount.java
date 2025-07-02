package com.autobots.bankApp;

public class DepositAccount extends BankAccount{


    public DepositAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    @Override
    public void deposit(double amount) {
balance += amount;//пополнили счет
        addTransaction("Deposit",amount);

    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance ){
            balance-= amount;
            addTransaction("Withdraw",amount);
            return true;
        }
        return false;
    }
}


