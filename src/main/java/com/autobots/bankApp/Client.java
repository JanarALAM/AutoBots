package com.autobots.bankApp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {

    private final String fullname;
    private final String clientId;
    private final String pin;
    private final List<BankAccount> accounts = new ArrayList<>();

    public Client(String fullname, String pin) {
        this.fullname = fullname;
        this.pin = pin;
        this.clientId = String.valueOf(UUID.randomUUID());
    }
    // метод ктоторый будем проверять где пользователь вводит правильный пин

    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);
    }

    // создали геттеры
   public void addAccount(BankAccount account) {
       accounts.add(account);
    }
        public String getFullname () {
            return fullname;
        }

        public String getClientId () {
            return clientId;
        }
        public List<BankAccount> getAccounts(){
        return accounts;
        }


}

