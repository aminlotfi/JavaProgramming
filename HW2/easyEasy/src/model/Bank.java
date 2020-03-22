package model;

import java.util.ArrayList;

public class Bank {
    public ArrayList<Bank> allBanks;
    public String name;

    public Bank(String name) {
        this.name = name;
    }

    public Bank getBankWithName(String name){
        for (Bank bank :allBanks) {
            if (name.equals(bank.getName())) {
                return bank;
            }
        }
        return null;
    }

    public boolean isThereBankWithName (String name){
        for (Bank bank :allBanks) {
            if (name.equals(bank.getName())) {
                return true;
            }
        }
        return false;
    }

    public int getAccountInterestFromName(String type){
        if (type.startsWith("KOOTAH")){
            return 10;
        } else if (type.startsWith("BOLAN")){
            return 30;
        } else if (type.startsWith("VIZHE")){
            return 50;
        } else {
            return 0;
        }
    }

    public String getName() {
        return name;
    }
}
