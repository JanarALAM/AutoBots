package com.autobots.bankApp;

import java.time.LocalDateTime;

public class Transaction {

    private final String type;//это значит какие виды транзакций(deposit,withdraw,transfer)
    private final double amount;//cумма
    private final LocalDateTime timeStamp= LocalDateTime.now();//будет всегда брать текущее время

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f",timeStamp,type,amount);
    }
}
