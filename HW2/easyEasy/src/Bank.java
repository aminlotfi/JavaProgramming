import java.util.ArrayList;

public class Bank {
    private static ArrayList<Bank> allBanks = new ArrayList<>();
    private String name;

    public Bank(String name) {
        this.name = name;
        allBanks.add(this);
    }

    public static Bank getBankWithName(String name){
        for (Bank bank :allBanks) {
            if (name.equals(bank.getName())) {
                return bank;
            }
        }
        return null;
    }

    public static boolean isThereBankWithName (String name){
        for (Bank bank :allBanks) {
            if (name.equals(bank.getName())) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
