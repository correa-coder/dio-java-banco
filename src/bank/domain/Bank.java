package bank.domain;

import java.util.List;

import bank.enums.AccountType;
import bank.enums.Status;
import bank.models.User;

import java.util.ArrayList;

public class Bank {

    private String name;
    private List<BankAccount> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<BankAccount>();
    }

    public BankAccount createAccount(AccountType accountType, User user, double balance) {
        BankAccount account = null;

        switch (accountType) {
            case CHECKING:
                account = new CheckingAccount(user, balance);
                break;
            case SAVINGS:
                account = new SavingsAccount(user, balance);
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown account type: %s", accountType));
        }

        System.out.println(String.format("%c Created %s account on \"%s\" for %s", Status.SUCCESS.getSymbol(),
                accountType, this.name, user.name()));
        this.accounts.add(account);
        return account;
    }

    public void printAccounts() {
        System.out.println();
        System.out.println(String.format("Accounts on %s (%d)", this.name, this.accounts.size()));

        this.accounts
                .stream()
                .forEach((account) -> System.out.println("- " + account.toString()));
    }
}
