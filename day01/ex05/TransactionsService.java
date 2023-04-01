package ex05;

public class TransactionsService {
    private final UsersArrayList userList = new UsersArrayList();
    private final TransactionsLinkedList TransList = new TransactionsLinkedList();

    public User getUser(int id){ return userList.findUserID(id);}
    public void addUser(User newUser) {
       this.userList.AddUser(newUser);
    }
    public int getUserBalance(User user){
        return user.getBalance();
    }
//    public int getUserBalance(int id){ return userList.findUserID(id).getBalance();}

    public void removeTransaction(String[] userData){
        User u = userList.findUserID(Integer.valueOf(userData[0]));
        u.getTransactions().removeById(userData[1]);
        getTransList().removeById(userData[1]);
    }
    public void doTransaction(int id1, int id2, int sum) throws IllegalTransactionException {
        Transaction t1 = new Transaction(userList.findUserID(id1), userList.findUserID(id2));
        Transaction t2 = new Transaction(t1);
        t1.setTransferAmount(sum);
        t2.setTransferAmount(sum*(-1));
        User u1 = userList.findUserID(id1);
        User u2 = userList.findUserID(id2);
        u1.addTransfer(t1);
        u2.addTransfer(t2);
        TransList.addTransaction(t1);
        TransList.addTransaction(t2);
        u1.setBalance(getUserBalance(u1) - sum);
        u2.setBalance(getUserBalance(u2) + sum);
    }

    public TransactionsLinkedList getTransList() {
        return TransList;
    }
}
