package bank.domain;

import bank.enums.Status;
import bank.interfaces.IAccount;
import bank.models.User;

public abstract class BankAccount implements IAccount {
    private static final int DEFAULT_BRANCH = 1;
    private static int SEQUENTIAL = 1;

    protected int branch = DEFAULT_BRANCH;
    protected int number;

    protected double balance = 0;

    protected User user;

    public BankAccount() {
        this.number = SEQUENTIAL++;
    }

    public BankAccount(User user) {
        this.user = user;
        this.number = SEQUENTIAL++;
    }

    public BankAccount(int branch, int number, double balance, User user) {
        this.branch = branch;
        this.number = number;
        this.balance = balance;
        this.user = user;
    }

    public int getBranch() {
        return branch;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println(String.format("(-) $%.2f withdrawn", amount));
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(String.format("(+) $%.2f deposited", amount));
    }

    @Override
    public void transfer(double amount, BankAccount targetBank) {
        if (balance - amount < 0) {
            System.out.println(String.format("%c Failed to transfer $%.2f (Not enough balance)",
                    Status.FAILURE.getSymbol(), amount));
            return;
        }

        this.withdraw(amount);
        targetBank.deposit(amount);

        System.out.println(String.format("%c Transferred $%.2f to bank %d.%nCurrent balance: $%.2f",
                Status.SUCCESS.getSymbol(), amount,
                targetBank.getNumber(), balance));
    }

    @Override
    public void printInfo() {
        System.out.println(String.format("Branch: %d", branch));
        System.out.println(String.format("Number: %d", number));
        System.out.println(String.format("Balance: $%.2f", balance));
        System.out.println(String.format("User: %s%n", user.name()));
    }
}
