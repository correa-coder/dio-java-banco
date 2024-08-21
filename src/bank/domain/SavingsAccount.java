package bank.domain;

import bank.enums.AccountType;
import bank.models.User;

public class SavingsAccount extends BankAccount {
    public AccountType accountType = AccountType.SAVINGS;

    public SavingsAccount(User user) {
        super.user = user;
    }

    public SavingsAccount(User user, double balance) {
        super.user = user;
        super.balance = balance;
    }

    @Override
    public void printInfo() {
        System.out.println("Account type: Saving account");
        super.printInfo();
    }

    @Override
    public String toString() {
        return String.format("SavingsAccount [user=%s, balance=%.2f]", super.getUser().name(), super.getBalance());
    }
}
