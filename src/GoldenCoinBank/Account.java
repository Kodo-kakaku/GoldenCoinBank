package GoldenCoinBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {
    private final long id;
    List<String> goldenCoins;
    public Account(long id, String... goldenCoins) {
        this.id = id;
        this.goldenCoins = new ArrayList<>();
        this.goldenCoins.addAll(Arrays.asList(goldenCoins));
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return this.id == account.id;
    }
}
