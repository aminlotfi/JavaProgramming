import java.security.PublicKey;
import java.util.ArrayList;

public class Account {
    public ArrayList<Account> allAccounts;
    public Bank bank;
    public int id;
    public int money;
    public int duration;
    public int interest;
    public Customer customer;

    public Account(Bank bank, int id, int money, int interest, Customer customer, int duration) {
        this.bank = bank;
        this.id = id;
        this.money = money;
        this.interest = interest;
        this.customer = customer;
        this.duration = duration;
        this.allAccounts = new ArrayList<>();
    }

    public void passMonth(){

    }

    public void deleteAccount(Account account){

    }

    public int getId() {
        return id;
    }

    public double getAmountOfMoneyForLeaving(){

    }

    public Bank getBank() {
        return bank;
    }

    public void  passMonthEach(){

    }
}

