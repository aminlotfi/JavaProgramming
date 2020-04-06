import java.util.ArrayList;

public class Account {
    private static ArrayList<Account> allAccounts = new ArrayList<>();
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
        allAccounts.add(this);
    }

    public static void passMonth(){
        ArrayList<Account> s = new ArrayList<>();
        for (Account account : allAccounts){
            if (account.remainingDuration == 1){
                s.add(account);
            } else {
                account.passMonthEach();
            }
        }
        for (Account account : s) {
            account.passMonthEach();
        }
    }

    public static void deleteAccount(Account account){
        allAccounts.remove(account);
    }

    public int getId() {
        return id;
    }

    public double getAmountOfMoneyForLeaving(){
        if (remainingDuration == 0){
            double moneyDouble = (((double) interest) / 100) + 1;
            return (moneyDouble) * (double) money;
        }
        return money;
    }

    public Bank getBank() {
        return bank;
    }

    private void passMonthEach(){
        if (remainingDuration > 0){
            remainingDuration--;
        }
        if (remainingDuration == 0){
            Customer.getCustomerByName(customer.getName()).leaveAccount(id);
            allAccounts.remove(this);
            remainingDuration--;
        }
    }
}