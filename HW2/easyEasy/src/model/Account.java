package model;

import java.util.ArrayList;

public class Account {
    public ArrayList<Account> allAccounts;
    public Bank bank;
    private int id;
    public int money;
    public int remainingDuration;
    private int interest;
    public Customer customer;

    public Account(Bank bank, int id, int money, int interest, Customer customer, int remainingDuration) {
        this.bank = bank;
        this.id = id;
        this.money = money;
        this.interest = interest;
        this.customer = customer;
        this.remainingDuration = remainingDuration;
        this.allAccounts = new ArrayList<>();
    }

    public void passMonth(){
        int s = allAccounts.size()-1;
        for (int i = s; i > -1; i--) {
            allAccounts.get(i).remainingDuration--;
            if (allAccounts.get(i).remainingDuration == 0){
                allAccounts.get(i).passMonthEach();
            }
        }
    }

    public void deleteAccount(Account account){
        for (int i = 0; i<allAccounts.size(); i++){
            if (allAccounts.get(i) == account){
                allAccounts.remove(account);
            }
        }
    }

    public int getId() {
        return id;
    }

    public double getAmountOfMoneyForLeaving(){
        if (remainingDuration > 0){
            return this.money;
        }
        return this.money += interest;
    }

    public Bank getBank() {
        return bank;
    }

    public void passMonthEach(){

    }
}