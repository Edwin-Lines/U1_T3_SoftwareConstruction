package bank.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class BankTextReader {

    private ArrayList<String> bankCustomer = null;

    public ArrayList<String> bankReader(String fileName) {
        try {
            Scanner fileReader = new Scanner(new FileReader(fileName));
            ArrayList<String> clientList = new ArrayList<>();
            while (fileReader.hasNext()) {
                clientList.add(fileReader.next());
            }
            fileReader.close();
            bankCustomer = clientList;
        } catch (Exception exc) {
            System.err.print(exc);
        }
        return bankCustomer;
    }

    public Hashtable<String, String> bankHashReader(String filename) {
        ArrayList<String> array = bankReader(filename);
        Hashtable<String, String> table = new Hashtable<>();
        // Cambiar split
        String[] split;
        String fileRow;
        String fullName;
        int i;
        for (i = 0; i < array.size(); i++) {
            fileRow = array.get(i);
            split = fileRow.split(",", 4);
            fullName = split[1] + split[2];
            table.put(fullName, fileRow);
        }
        return table;
    }
}
