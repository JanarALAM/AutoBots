package com.autobots.java.bankApplication;

public class Mbank  extends BankBase {
    double funds = 0;

    public Mbank(long accountNumber, String client, String bankName)  {
        super(accountNumber, client, bankName);
        this.funds=funds;
BankBase.addToAllBase(this);
    }


    @Override
    public void deposit(double amount) {
        if (amount > 200000) {

            throw new IllegalArgumentException("You have limit 200000 to deposit");

        }
        funds += amount;

    }

    @Override
    public void withDraw(double amount) {
        if (amount >150000) {

            throw new IllegalArgumentException("You have limit 150000 to withDraw");

        }
        funds-=amount;
    }

    @Override
    public String toString() {
        return getClient()+ "Mbank{" +
                "funds=" + funds +
                '}';
    }
}