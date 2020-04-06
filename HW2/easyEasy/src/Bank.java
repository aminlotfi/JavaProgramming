import java.util.ArrayList;

public class Bank {
    private static int interests;
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

    public int getAccountInterestFromName(String type){
        if (type.startsWith("KOOTAH")){
            interests = 10;
            return interests;
        } else if (type.startsWith("BOLAN")){
            interests = 30;
            return interests;
        } else if (type.startsWith("VIZHE")){
            interests = 50;
            return interests;
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }
}

