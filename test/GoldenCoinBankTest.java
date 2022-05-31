import ClientInfo.Account;
import ClientInfo.Client;
import ClientInfo.Id;
import GoldenCoinBank.Bank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class GoldenCoinBankTest {
    @Test
    @DisplayName("Checking for correctness of comparison")
    public void equalsTest() {
        System.out.println("Start equals test");
        Account firstAcc = new Account(new Id(1L), "5");
        Account secondAcc = new Account(new Id(1L), "1");
        Account lastAcc = new Account(new Id(2L), "323");

        Assertions.assertFalse(firstAcc.equals(null));
        Assertions.assertFalse(firstAcc.equals(lastAcc));

        Assertions.assertTrue(firstAcc.equals(firstAcc));
        Assertions.assertTrue(firstAcc.equals(secondAcc));
        System.out.println("Equals test: OK\n");
    }

    @Test
    @DisplayName("Find client account")
    public void findAccountInCollections() {

        final Id pavelId = new Id(1L);
        final Id kateId = new Id(2L);
        final Id antonyId = new Id(3L);

        Bank bank = new Bank();

        bank.createNewClient(pavelId, 18, "Pavel");
        bank.createNewClient(kateId, 16, "Kate");
        bank.createNewClient(antonyId, 32, "Antony");

        Client pavel = bank.getClientById(pavelId);
        Client kate = bank.getClientById(kateId);
        Client antony = bank.getClientById(antonyId);

        System.out.println("Find client account by ID in BANK:");
        System.out.printf("Client id: %d, fined client id: %d, client name: %s\n",
                pavelId.id(), pavel.getId().id(), pavel.getName());
        Assertions.assertEquals(pavelId.id(), pavel.getId().id());

        System.out.printf("Client id: %d, fined client id: %d, client name: %s\n",
                kateId.id(), kate.getId().id(), kate.getName());
        Assertions.assertEquals(kateId.id(), kate.getId().id());

        System.out.printf("Client id: %d, fined client id: %d, client name: %s\n\n",
                antonyId.id(), antony.getId().id(), antony.getName());
        Assertions.assertEquals(antonyId.id(), antony.getId().id());
    }

    @Test
    @DisplayName("Find client by account")
    public void findClientInCollections() {
        final Id pavelId = new Id(1L);
        final Id kateId = new Id(2L);
        final Id antonyId = new Id(3L);

        Bank bank = new Bank();

        bank.createNewClient(pavelId, 18, "Pavel");
        bank.createNewClient(kateId, 16, "Kate");
        bank.createNewClient(antonyId, 32, "Antony");

        Client pavel = bank.getClientById(pavelId);
        Client kate = bank.getClientById(kateId);
        Client antony = bank.getClientById(antonyId);

        bank.addClientAccount(pavel, "1111");
        bank.addClientAccount(kate, "2222");
        bank.addClientAccount(antony, "3333");

        Account pavelAccount = new Account(pavelId, "11111");
        Account kateAccount = new Account(kateId, "33333");
        Account antonyAccount = new Account(antonyId, "2313123");

        Client someClient1 = bank.getClientByAccount(pavelAccount);
        Client someClient2 = bank.getClientByAccount(kateAccount);
        Client someClient3 = bank.getClientByAccount(antonyAccount);

        System.out.println("Find client by account in BANK:");
        System.out.printf("Account id: %d, fined account id: %d\n", pavelAccount.getId().id(), someClient1.getId().id());
        Assertions.assertEquals(pavelAccount.getId().id(), someClient1.getId().id());

        System.out.printf("Account id: %d, fined account id: %d\n", kateAccount.getId().id(), someClient2.getId().id());
        Assertions.assertEquals(kateAccount.getId().id(), someClient2.getId().id());

        System.out.printf("Account id: %d, fined account id: %d\n\n", antonyAccount.getId().id(), someClient3.getId().id());
        Assertions.assertEquals(antonyAccount.getId().id(), someClient3.getId().id());
    }
}
