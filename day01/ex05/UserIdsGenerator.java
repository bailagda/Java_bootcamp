package ex05;

public class UserIdsGenerator {
    int lastId;
    public static final UserIdsGenerator generator = new UserIdsGenerator();
    private UserIdsGenerator() {}

    static UserIdsGenerator getInstance() {
        return generator;
    }
    int generateId() {
        lastId+= 1;
        return lastId;
    }
}
