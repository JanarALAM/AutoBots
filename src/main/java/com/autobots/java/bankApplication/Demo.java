package com.autobots.java.bankApplication;

public class Demo {
    public static void main(String[] args) throws Exception {

      Bank Kairat= new Mbank(123456,"Kairat","Mbank");
        BankBase Altynai = new ProblemaBank(345677, "Altynai","ProblemaBank");
        Bank.transferFunds(Altynai, Kairat, 500);
        System.out.println(Kairat);
        System.out.println(Altynai);
        Kairat.withDraw(400);
        System.out.println(Kairat);

Bank Madina= new ProblemaBank(565643,"Madina","ProblemaBank");
Bank.transferFunds(Madina,Altynai,100);
        System.out.println(Madina);
        System.out.println(Altynai);
        System.out.println(BankBase.allBanksClients);

    }
}
