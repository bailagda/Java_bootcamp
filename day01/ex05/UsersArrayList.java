package ex05;

public class UsersArrayList
    implements UserList {
    private User[] users = new User[10];
    private int usersCount = 0;
    @Override
    public void AddUser(User newUser) {
        if(usersCount > users.length) {
            User[] tmp = new User[users.length * 2];
            System.arraycopy(users, 0, tmp, 0, users.length);
            users = tmp;
        }
        for (int i = 0; i<users.length; ++i) {
            if(users[i] == null){
                users[i] = newUser;
                usersCount+=1;
                break;
            }
        }
    }

    @Override
    public User findUserID(int ID) {
        for(User user: users) {
            if(ID == user.getID()) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User findUserIndex(int index) {
        if(users[index] != null) {
            return users[index];
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public int NumberOfUsers() {
        return usersCount;
    }
}

