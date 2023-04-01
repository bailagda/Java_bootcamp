package ex04;

import java.util.UUID;

public class TransactionsService {
    private final UsersArrayList userList = new UsersArrayList();
    private final TransactionsLinkedList TransList = new TransactionsLinkedList();

    public void addUser(User newUser) {
       this.userList.AddUser(newUser);
    }
    public int getUserBalance(User user){
        return user.getBalance();
    }
//    Выполнение транзакции перевода (указаны идентификаторы пользователей и сумма перевода)
//    создаются две транзакции типа ДЕБЕТ/КРЕДИТ и
//    добавляются к получателю и отправителю.
//    ID обеих транзакций должны совпадать
    public void doTransaction(int id1, int id2, int sum) throws IllegalTransactionException {
        Transaction t1 = new Transaction(userList.findUserID(id1), userList.findUserID(id2));
        Transaction t2 = new Transaction(t1);
        t1.setTransferAmount(sum);
        t2.setTransferAmount(sum*(-1));
        User u1 = userList.findUserID(id1);
        User u2 = userList.findUserID(id2);
        u1.addTransfer(t1);
        u2.addTransfer(t2);
        u1.setBalance(getUserBalance(u1) - sum);
        u2.setBalance(getUserBalance(u2) + sum);
    }

    public TransactionsLinkedList getTransList() {
        return TransList;
    }
}
