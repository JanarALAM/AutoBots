package com.autobots.java.bankApplication;

import java.util.*;
import java.util.stream.Collectors;

public abstract class BankBase implements Bank {
    private long accountNumber;
    private String client;
    public String bankName;

    static HashSet<BankBase> allBanksClients = new HashSet<>();

    public BankBase(long accountNumber, String client, String bankName) throws IllegalArgumentException {
        if (Long.toString(accountNumber).length() != 6) {
            throw new IllegalArgumentException("Account number should be 6 digits");
        } else if (client.length() < 5) {
            throw new IllegalArgumentException("The name can't be less 5");
        }
        this.accountNumber = accountNumber;
        this.client = client;
        this.bankName = bankName;
    }

    protected static void addToAllBase(BankBase bank) {
        for (BankBase client:allBanksClients){
            if (client.getAccountNumber()==bank.getAccountNumber()){
                throw new IllegalArgumentException("This account number already excist");
            }
            if (client.getClient().equals(bank.getClient())){
                throw new IllegalArgumentException("Account alrady excist");
            }
        }
        allBanksClients.add(bank);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getClient() {
        return client;
    }
    public static void filterByBank(String bank){
        List<BankBase> sorted= allBanksClients.stream().filter(b->b.getBankName().equals(bank)).collect(Collectors.toList());
        System.out.println(bank+":"+sorted);

    }

    public static void filterByBank(){
        Map<String, Set<BankBase>> grouped=allBanksClients.stream().collect(Collectors.groupingBy(BankBase::getBankName,Collectors.toSet()));
        System.out.println(grouped);
        for (Map.Entry<String,Set<BankBase>> bank:grouped.entrySet()){
            System.out.println(bank);
        }
    }

    public String getBankName(){
        return bankName;
    }
}