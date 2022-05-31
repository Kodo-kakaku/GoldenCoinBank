package ClientInfo;

public class Account {
    private final Id id;
    private String goldenCoins;
    public Account(Id id, String goldenCoins) {
        this.id = id;
        this.goldenCoins = goldenCoins;
    }
    public Id getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return this.id.equals(account.id);
    }
}
