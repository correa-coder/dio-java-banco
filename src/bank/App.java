package bank;

import bank.domain.Bank;
import bank.domain.BankAccount;
import bank.enums.AccountType;
import bank.models.User;

public class App {
    public static void main(String[] args) throws Exception {
        // withdraw and deposit example
        Bank libertyCityBank = new Bank("Liberty City Bank");
        BankAccount bankAccount1 = libertyCityBank
                .createAccount(AccountType.CHECKING,
                        new User("Franklin Clinton", "Frankie@eyefind.info"), 3000);
        bankAccount1.withdraw(1500);
        bankAccount1.printInfo();
        bankAccount1.deposit(1500);
        bankAccount1.printInfo();

        // transfer examples
        User michaelDeSanta = new User("Michael De Santa", "Mike@eyefind.info");
        Bank lasVenturasBank = new Bank("Las Venturas Bank");
        BankAccount bankAccount2 = lasVenturasBank.createAccount(AccountType.CHECKING, michaelDeSanta, 5_000);
        BankAccount bankAccount3 = lasVenturasBank.createAccount(AccountType.SAVINGS, michaelDeSanta, 15_000);
        lasVenturasBank.printAccounts();

        bankAccount3.transfer(5_000, bankAccount2);

        // trying to transfer more than the balance should be denied
        bankAccount1.transfer(6_000, bankAccount2);
    }
}
