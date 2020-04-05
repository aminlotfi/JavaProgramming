package model;

import java.util.ArrayList;

public class Account {
    private static ArrayList<Account> allAccounts;
    private Bank bank;
    private int id;
    private int money;
    private int remainingDuration;
    private int interest;
    private Customer customer;

    public Account(Bank bank, int id, int money, int interest, Customer customer, int remainingDuration) {
        this.bank = bank;
        this.id = id;
        this.money = money;
        this.interest = interest;
        this.customer = customer;
        this.remainingDuration = remainingDuration;
        this.allAccounts = new ArrayList<>();
    }

    public static void passMonth(){
        ArrayList<Account> s = new ArrayList<>();
        for (Account account : allAccounts){
            if (account.remainingDuration == 0){
                s.add(account);
            }
            account.passMonthEach();
        }
        allAccounts.removeAll(s);
    }

    public static void deleteAccount(Account account){
        allAccounts.remove(account);
    }

    public int getId() {
        return id;
    }

    public double getAmountOfMoneyForLeaving(){
        if (remainingDuration > 0){
            return this.money;
        }
        return this.money *= ((interest/100)+1);
    }

    public Bank getBank() {
        return bank;
    }

    private void passMonthEach(){
        if (remainingDuration > 0){
            remainingDuration--;
        } else if (remainingDuration == 0){
            Customer.getCustomerByName(customer.getName()).leaveAccount(id);
        }
    }
}