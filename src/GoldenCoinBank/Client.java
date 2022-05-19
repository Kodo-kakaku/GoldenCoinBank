package GoldenCoinBank;

public class Client {
    private final long id;
    private int age;
    private String name;

    public Client(long id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public long getId() {
        return id;
    }
}
