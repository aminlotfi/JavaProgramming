package model;

import java.util.ArrayList;

public class Loan {
    public ArrayList<Loan> allLoans;
    public Customer customer;
    public int duration;
    public int remainingPayments;
    public int interest;
    public int amount;

    public Loan(Customer customer, int duration, int interest, int amount) {
        this.customer = customer;
        this.duration = duration;
        this.interest = interest;
        this.amount = amount;
        this.allLoans = new ArrayList<>();
    }

    public static void passMonth(){

    }

    public double getPaymentAmount(){

    }

    public void passMonthEach(){

    }
}
