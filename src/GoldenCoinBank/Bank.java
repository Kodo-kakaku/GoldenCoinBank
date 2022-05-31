package GoldenCoinBank;

import ClientInfo.Account;
import ClientInfo.Client;
import ClientInfo.Id;

import java.util.HashMap;

public class Bank {
    private final HashMap<Id, Client> clients;

    public Bank() {
        this.clients = new HashMap<>();
    }

    public void createNewClient(Id id, int age, String name) {
        Client client = new Client(id, age, name);
        this.clients.put(client.getId(), client);
    }

    public void addClientAccount(Client client, String goldenCoins) {
        Id id = client.getId();
        if(this.clients.containsKey(id)) {
            Client tmpClient = this.clients.get(id);
            tmpClient.addNewAccount(new Account(id, goldenCoins));
        }
    }

    public Client getClientByAccount(Account account) {
        return this.clients.get(account.getId());
    }

    public Client getClientById(Id id) {
        return this.clients.get(id);
    }
}
