import java.util.ArrayList;

public class Loan {
    private static ArrayList<Loan> allLoans = new ArrayList<>();
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
        remainingPayments=duration;
        allLoans.add(this);
    }

    public static void passMonth() {
        if (!allLoans.isEmpty()) {
            for (Loan loan : allLoans) {
                loan.passMonthEach();
            }
        }
    }

    private double getPaymentAmount() {
        return  ((double)amount * (((double) interest / 100) + 1)) / (double) duration;
    }

    private void passMonthEach() {
        if (remainingPayments > 0) {
            if (customer.canPayLoan(getPaymentAmount())) {
                customer.payLoan((-1) * getPaymentAmount());
                remainingPayments--;
            }
        }
    }
}
