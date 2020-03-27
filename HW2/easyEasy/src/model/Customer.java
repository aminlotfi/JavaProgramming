package model;

import java.util.ArrayList;

public class Customer {
    public ArrayList<Customer> allCustomers;
    public String name;
    public double moneyInSafe;
    public ArrayList<Account> allActiveAccounts;
    public int totalNumberOfAccountsCreated;
    public int negativeScore;

    public Customer(String name, double moneyInSafe) {
        this.name = name;
        this.moneyInSafe = moneyInSafe;
        this.allCustomers = new ArrayList<>();
        this.allActiveAccounts = new ArrayList<>();
    }

    public Customer getCustomerByName (String name){
        for (Customer customer :allCustomers) {
            if (name.equals(customer.getName())) {
                return customer;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void createNewAccount(Bank bank, int money, int duration, int type){
        Account account = new Account(bank, this.totalNumberOfAccountsCreated, money, this, this, duration);

    }

    public void leaveAccount(int accountId){

    }

    public boolean canPayLoan(double amount){

    }

    public double getMoneyInSafe() {
        return moneyInSafe;
    }

    public void setMoneyInSafe(double moneyInSafe) {
        this.moneyInSafe = moneyInSafe;
    }

    public void getLoan(int duration, int interest, int money){

    }

    public void payLoan(double amount){

    }

    public boolean canGetLoan(){

    }

    public int getNegativeScore() {
        return negativeScore;
    }

    public void addNegativeScore(){

    }

    public boolean hasActiveAccountInBank(Bank bank){

    }

    public Account getAccountWithId(int id){
        for (int i = 0; i < allActiveAccounts.size(); i++) {
            if (allActiveAccounts.get(i).getId() == id ){
                return allActiveAccounts.get(i);
            }
        }
        return null;
    }
}

