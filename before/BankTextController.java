package bank.controller;

import java.util.ArrayList;
import bank.model.BankTextReader;
import java.util.Hashtable;

public class BankTextController {

    public String[][] getClientsInfo(String Filename) {
        BankTextReader bankBuilder = new BankTextReader();
        ArrayList<String> fileData;
        fileData = bankBuilder.bankReader(Filename);
        String[][] clientsInfo = new String[fileData.size()][4];
        String fileRow;
        String accounts;
        String[] customerInfo;
        int i, j;
        for (i = 0; i < fileData.size(); i++) {
            fileRow = fileData.get(i);
            customerInfo = fileRow.split(",");
            accounts = customerInfo[3];
            for (j = 6; j < customerInfo.length; j++) {
                accounts = accounts + ", " + customerInfo[j];
                j = j + 2;
            }
            clientsInfo[i][3] = accounts;
            for (j = 0; j < 3; j++) {
                clientsInfo[i][j] = customerInfo[j];
            }
        }
        return clientsInfo;
    }

    // todo cambiar nombre a uno más explicativo
    public String[] getHeader() {
        String[] header = { "ID", "First Name", "Last Name", "Accounts" };
        return header;
    }

    public String[][] searchCustomer(String primaryKey) {
        BankTextReader bankBuilder = new BankTextReader();
        Hashtable<String, String> fileData = bankBuilder.bankHashReader("Bank.txt");
        String[][] searchedCustomer = { { " ", " ", " ", " " } };
        if (fileData.containsKey(primaryKey)) {
            String fileRow;
            String accounts;
            String[] customerInfo;
            fileRow = fileData.get(primaryKey);
            customerInfo = fileRow.split(",");
            int j;
            for (j = 0; j < 3; j++) {
                searchedCustomer[0][j] = customerInfo[j];
            }
            accounts = customerInfo[3];
            for (j = 6; j < customerInfo.length; j++) {
                accounts = accounts + ", " + customerInfo[j];
                j = j + 2;
            }
            searchedCustomer[0][3] = accounts;
        } else {
            searchedCustomer = null;
        }
        return searchedCustomer;
    }
}
