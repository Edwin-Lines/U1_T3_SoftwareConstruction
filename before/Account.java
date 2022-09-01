package bank.model;

public class Account {
    public static final String CREDIT = "CREDIT";
    public static final String DEBIT = "DEBIT";
    private static int primaryKey;
    private int accountID;
    private double balance;
    private String accountType;

    public Account(String accountType, double balance) {
        this.accountID = primaryKey;
        primaryKey++;
        this.accountType = accountType;
        this.balance = balance;
    }

    public double withdraw(double ammount) {
        if (balance >= ammount) {
            balance = balance - ammount;
        }
        return balance;
    }

    public double deposit(double ammount) {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public String toString() {
        return "ID Account: " + accountID + ", Type: " + accountType + " ,Balance: " + balance;
    }
}
