package com.autobots.bankApp;

public class Demo {
    public static void main(String[] args) {

        static Scanner scanner = new Scanner(System.in);
        static Map<String, Client> clients = new HashMap<>();

        public static void main(String[] args) {

            Client asan = new Client("asan uson", "123");
            DepositAccount asanDepositAccount = new DepositAccount(asan, Currency.USD);
            CreditAccount asanCreditAccount = new CreditAccount(asan, Currency.EUR);

            asan.addAccount(asanDepositAccount);
            asan.addAccount(asanCreditAccount);

            System.out.println(asan.getClientID());

            clients.put(asan.getClientID(), asan);

            System.out.println("===========Welcome to MBank=============");
            System.out.println("Please enter client ID");
            String clientID = scanner.nextLine();
            Client client = clients.get(clientID);
            if (client==null){
                System.out.println("Client was not found");
                return;
            }
            System.out.println("Please enter pin code");
            String pinCode=scanner.nextLine();
            if(!client.authenticate(pinCode)){
                System.out.println("You entered wrong pin code!");
                return;
            }
            System.out.println(client.getFullname()+"welcome to Mbank");
            while (true) {
                System.out.println("1. Посмотреть счета");
                System.out.println("перевести между счетами");
                System.out.println("Показать чек");
                System.out.println("Выход из системы");

                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        for (BankAccount bankAccount : client.getAccounts()) {
                            System.out.println("%s| %s| БалансЖ %ю2f  %s\n",
                                    bankAccount.getClass().getSimpleName(),
                                    bankAccount.getAccountNumber(), BankAccount.getBalance(), bankAccount.getCurrency());
                        }
                        break;
                    case "2":
                        System.out.println("Введите номер счета отправителя");
                        String fromId = scanner.nextLine();
                        System.out.println("введите номер счета получателя");
                        String toID = scanner.nextLine();
                        System.out.println("Сумма");
                        double amount = Double.parseDouble(scanner.nextLine());
                        BankAccount from = findAccount(fromId);
                        BankAccount to = findAccount(toID);
                        if (from != null && to != null) {
                            boolean result = BankService.transfer(from, to, amount);
                            System.out.println(result ? "Операция прошла успешна" : "Ошибка перевода");
                        } else {
                            System.out.println("счета не найдены");
                        }
                        break;

                    case "3":
                        for (BankAccount bankAccount : client.getAccounts()) {
                            System.out.println("\n == чек по счету" + bankAccount.getAccountNumber());
                            for (Transaction transaction : bankAccount.getTransaction()) ;
                            System.out.println(transaction);
                        }
                }
                break;
                class "D":
                System.out.println("Выход");
                return;

                default:
                    System.out.println("Не верный выбор");

            }





        }
        private static BankAccount findAccount(String accountNumber){
            for (Client client : clients.values()) {
                for (BankAccount bankAccount : client.getAccounts()) {
                    if (bankAccount.getAccountNumber().equals(accountNumber)) {
                        return bankAccount;
                    }
                }
            }
            return null;
        }
    }
}
