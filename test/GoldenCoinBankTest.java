import GoldenCoinBank.Account;
import GoldenCoinBank.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class GoldenCoinBankTest {
    @Test
    @DisplayName("Checking for correctness of comparison")
    public void equalsTest() {
        Account firstAcc = new Account(1, "1", "5");
        Account secondAcc = new Account(1, "1", "5");
        Account lastAcc = new Account(2, "1", "5");

        Assertions.assertFalse(firstAcc.equals(null));
        Assertions.assertFalse(firstAcc.equals(lastAcc));

        Assertions.assertTrue(firstAcc.equals(firstAcc));
        Assertions.assertTrue(firstAcc.equals(secondAcc));

    }

    @Test
    @DisplayName("Find client account")
    public void findAccountInCollections() {
        Client firstClient = new Client(1, 18, "Pavel");
        Client secondClient = new Client(2,16, "Kate");
        Client lastClient = new Client(3,18, "Antony");

        Account firstClientAccounts = new Account(1, "1", "5");
        Account secondClientAccounts = new Account(2, "1", "5");
        Account lastClientAccounts = new Account(3, "1", "5");

        Map<Client, Account> bankWithClientsAndGoldenCoins = new HashMap<>();
        bankWithClientsAndGoldenCoins.put(firstClient, firstClientAccounts);
        bankWithClientsAndGoldenCoins.put(secondClient, secondClientAccounts);
        bankWithClientsAndGoldenCoins.put(lastClient, lastClientAccounts);

        System.out.println("Find client account in map:");
        System.out.printf("Client id: %d, fined account id: %d\n",
                firstClientAccounts.getId(), bankWithClientsAndGoldenCoins.get(firstClient).getId());
        Assertions.assertEquals(firstClientAccounts.getId(), bankWithClientsAndGoldenCoins.get(firstClient).getId());

        System.out.printf("Client id: %d, fined account id: %d\n",
                secondClientAccounts.getId(), bankWithClientsAndGoldenCoins.get(secondClient).getId());
        Assertions.assertEquals(secondClientAccounts.getId(), bankWithClientsAndGoldenCoins.get(secondClient).getId());

        System.out.printf("Client id: %d, fined account id: %d\n",
                lastClientAccounts.getId(), bankWithClientsAndGoldenCoins.get(lastClient).getId());
        Assertions.assertEquals(lastClientAccounts.getId(), bankWithClientsAndGoldenCoins.get(lastClient).getId());
    }

    @Test
    @DisplayName("Find client by account")
    public void findClientInCollections() {
        Client firstClient = new Client(1, 18, "Pavel");
        Client secondClient = new Client(2, 16, "Kate");
        Client lastClient = new Client(3, 18, "Antony");

        Account firstClientAccounts = new Account(1, "1", "5");
        Account secondClientAccounts = new Account(2, "1", "5");
        Account lastClientAccounts = new Account(3, "1", "5");

        Map<Client, Account> bankWithClientsAndGoldenCoins = new HashMap<>();
        bankWithClientsAndGoldenCoins.put(firstClient, firstClientAccounts);
        bankWithClientsAndGoldenCoins.put(secondClient, secondClientAccounts);
        bankWithClientsAndGoldenCoins.put(lastClient, lastClientAccounts);


        Set<Map.Entry<Client, Account>> entries = bankWithClientsAndGoldenCoins.entrySet();

        System.out.println("Find client account in map:");
        for(Map.Entry<Client, Account> entry: entries) {
            if (entry.getValue().equals(secondClientAccounts)) {
                System.out.printf("Client id: %d, fined account id: %d\n",
                        entry.getKey().getId(), secondClientAccounts.getId());
                Assertions.assertEquals(entry.getKey().getId(), secondClientAccounts.getId());
            }
        }

        for(Map.Entry<Client, Account> entry: entries) {
            if (entry.getValue().equals(lastClientAccounts)) {
                System.out.printf("Client id: %d, fined account id: %d\n",
                        entry.getKey().getId(), lastClientAccounts.getId());
                Assertions.assertEquals(entry.getKey().getId(), lastClientAccounts.getId());
            }
        }

        for(Map.Entry<Client, Account> entry: entries) {
            if (entry.getValue().equals(firstClientAccounts)) {
                System.out.printf("Client id: %d, fined account id: %d\n\n",
                        entry.getKey().getId(), firstClientAccounts.getId());
                Assertions.assertEquals(entry.getKey().getId(), firstClientAccounts.getId());
            }
        }
    }
}
