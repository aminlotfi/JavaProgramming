package model;

import java.util.ArrayList;

public class Loan {
    private static ArrayList<Loan> allLoans;
    private Customer customer;
    private int duration;
    private int remainingPayments;
    private int interest;
    private int amount;

    public Loan(Customer customer, int duration, int interest, int amount) {
        this.customer = customer;
        this.duration = duration;
        this.interest = interest;
        this.amount = amount;
        this.allLoans = new ArrayList<>();
    }

    public static void passMonth(){

        int s = allLoans.size()-1;
        for (int i = s; i > -1; i--) {
            allLoans.get(i).duration--;
            if (allLoans.get(i).duration == 0){
                allLoans.get(i).passMonthEach();
            }
        }
    }

    private double getPaymentAmount(){
        return amount = (amount*(interest/100)+1)/duration;
    }

    private void passMonthEach(){
        for (int i = 0; i < duration ; i++) {
            Customer customer = null;
            customer.payLoan(amount);
        }
        if (customer.canPayLoan(amount)){
            customer.setMoneyInSafe(amount * (-1));
        }
    }
}