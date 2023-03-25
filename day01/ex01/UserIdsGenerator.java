package ex01;

public class UserIdsGenerator {
    int lastId;
    public static final UserIdsGenerator generator = new UserIdsGenerator();
    private UserIdsGenerator() {}

    public static UserIdsGenerator getInstance() {
        return generator;
    }
    public int generateId() {
        lastId+= 1;
        return lastId;
    }
}
