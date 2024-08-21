package bank.domain;

import bank.enums.AccountType;
import bank.models.User;

public class CheckingAccount extends BankAccount {
    public AccountType accountType = AccountType.CHECKING;

    public CheckingAccount(User user) {
        super.user = user;
    }

    public CheckingAccount(User user, double balance) {
        super.user = user;
        super.balance = balance;
    }

    @Override
    public void printInfo() {
        System.out.println("Account type: Checking account");
        super.printInfo();
    }

    @Override
    public String toString() {
        return String.format("CheckingAccount [user=%s, balance=%.2f]", super.getUser().name(), super.getBalance());
    }
}
