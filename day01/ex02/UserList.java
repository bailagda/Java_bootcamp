package ex02;

import java.util.UUID;

public interface UserList {
    public void AddUser(User user);
    public User findUserID(int ID);
    public User findUserIndex(int index);
    public int NumberOfUsers();
}
