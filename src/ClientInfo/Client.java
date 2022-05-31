package ClientInfo;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final Id id;
    private int age;
    private String name;
    private final List<Account> accounts;

    public Client(Id id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addNewAccount(Account account) {
        this.accounts.add(account);
    }
}
