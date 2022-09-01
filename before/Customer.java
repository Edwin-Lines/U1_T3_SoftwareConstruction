package bank.model;

public class Customer {
    private static int PrimaryKey;
    private int customerID;
    private String firstName;
    private String lastName;
    private Account accounts[];
    private int numberOfAccounts;

    public Customer(String firstName, String lastName) {
        this.customerID = PrimaryKey;
        PrimaryKey++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, int maxNumAccount) {
        this.customerID = PrimaryKey;
        PrimaryKey++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new Account[maxNumAccount];
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public boolean addAccount(Account account) {
        boolean isAccountLimit = false;
        if (numberOfAccounts < accounts.length) {
            accounts[numberOfAccounts] = account;
            numberOfAccounts++;
            isAccountLimit = true;
        }
        return isAccountLimit;
    }

    public boolean removeAccount(int accountID) {
        boolean isAccountLimit = false;
        for (int i = 0; i < numberOfAccounts; i++) {
            if (accounts[i].getAccountID() == accountID) {
                accounts[i] = accounts[numberOfAccounts - 1];
                accounts[numberOfAccounts - 1] = null;
                numberOfAccounts--;
                isAccountLimit = true;
            }
        }

        return isAccountLimit;
    }

    public Account searchAccount(int accountID) {
        Account searchAccount = null;
        for (Account account : accounts) {
            if (account.getAccountID() == accountID) {
                searchAccount = account;
            }
        }
        return searchAccount;
    }

    public Account getAccount(int accountID) {
        return searchAccount(accountID);
    }

    public boolean equals(Object currentCustomer) {
        boolean isEqual = false;
        // Cambiar currentCustomer
        if (currentCustomer != null && currentCustomer instanceof Customer) {
            Customer tempCustomer = (Customer) currentCustomer;
            if (this.customerID == tempCustomer.customerID) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    public String toString() {
        String accountList = "ID Customer: " + this.customerID + " ,Fist Name: " + this.firstName +
                " ,Last Name: " + this.lastName + "\n" + "Accounts:" + "\n";

        for (int i = 0; i < numberOfAccounts; i++) {
            accountList += accounts[i].toString() + "\n";
        }
        return accountList;
    }

}
