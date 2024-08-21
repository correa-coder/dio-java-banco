package bank.interfaces;

import bank.domain.BankAccount;

public interface IAccount {
    void withdraw(double amount);

    void deposit(double amount);

    void transfer(double amount, BankAccount targetBank);

    void printInfo();
}
