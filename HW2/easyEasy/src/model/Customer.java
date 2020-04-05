package model;

import java.util.ArrayList;

public class Customer {
    private String name;
    private double moneyInSafe;
    private int totalNumberOfAccountsCreated = 0;
    private int negativeScore = 0;
    private static ArrayList<Customer> allCustomers = new ArrayList<>();
    private ArrayList<Account> allActiveAccounts = new ArrayList<>();

    public Customer(String name, double moneyInSafe) {
        this.name = name;
        this.moneyInSafe = moneyInSafe;
        allCustomers.add(this);
    }

    public static Customer getCustomerByName(String name) {
        for (int i = 0; i < allCustomers.size(); i++) {
            if (name.equals((allCustomers.get(i)).getName())) {
                return allCustomers.get(i);
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void createNewAccount(Bank bank, int money, int duration, int interest) {
        this.totalNumberOfAccountsCreated++;
        Account account = new Account(bank, this.totalNumberOfAccountsCreated + 1,money, interest, this, duration);
        this.allActiveAccounts.add(account);
        this.setMoneyInSafe((-1) * (money));
    }

    public void leaveAccount(int accountId) {
        Account account = this.getAccountWithId(accountId);
        if (account == null) {
            System.out.println("Chizi zadi?!");
        } else {
            this.setMoneyInSafe(account.getAmountOfMoneyForLeaving());
            allActiveAccounts.remove(account);
            Account.deleteAccount(account);
        }
    }

    public boolean canPayLoan(double amount) {
        if (amount >= this.getMoneyInSafe()) {
            this.negativeScore++;
            return false;
        } else {
            return true;
        }
    }

    public double getMoneyInSafe() {
        return moneyInSafe;
    }

    public void setMoneyInSafe(double moneyInSafe) {
        this.moneyInSafe += moneyInSafe;
    }

    public void getLoan(int duration, int interest, int money) {
        this.setMoneyInSafe(money);
    }

    public void payLoan(double amount) {
        this.setMoneyInSafe(amount);
    }

    public boolean canGetLoan() {
        if (this.getNegativeScore() < 5) {
            return true;
        } else {
            return false;
        }
    }

    public int getNegativeScore() {
        return negativeScore;
    }

    public boolean hasActiveAccountInBank(Bank bank) {
        for (Account allActiveAccount : allActiveAccounts) {
            if (bank.getName().equals(allActiveAccount.getBank().getName())) {
                return true;
            }
        }
        return false;
    }

    private Account getAccountWithId(int id) {
        for (Account allActiveAccount : allActiveAccounts) {
            if (id == allActiveAccount.getId()) {
                return allActiveAccount;
            }
        }
        return null;
    }

}