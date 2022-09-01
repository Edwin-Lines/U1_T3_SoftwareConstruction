package bank.model;

public class Bank {
    private Customer[] clients;
    private int currentNumClient;

    public Bank(int maxClients) {
        clients = new Customer[maxClients];
        currentNumClient = 0;
    }

    public boolean addCustomer(Customer client) {
        boolean isClientLimit = false;
        if (currentNumClient < clients.length) {
            clients[currentNumClient] = client;
            currentNumClient++;
            isClientLimit = true;
        }
        return isClientLimit;
    }

    public boolean removeCustomer(int IDcustomer) {
        boolean isClientLimit = false;
        for (int i = 0; i < currentNumClient; i++) {
            if (clients[i].getIDCustomer() == IDcustomer) {
                clients[i] = clients[currentNumClient - 1];
                clients[currentNumClient - 1] = null;
                currentNumClient--;
                isClientLimit = true;
            }
        }

        return isClientLimit;
    }

    public Customer searchClient(int clientID) {
        Customer searchedClient = null;
        for (Customer client : clients) {
            if (client.getIDCustomer() == clientID) {
                searchedClient = client;
            }
        }
        return searchedClient;
    }

    public String toString() {
        String clientList = "";
        for (int i = 0; i < currentNumClient; i++) {
            clientList += clients[i].toString() + "\n";
        }
        return clientList;
    }

}
