package ex04;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        TransactionsService ts = new TransactionsService();
        User u1 = new User("test1", 100);
        User u2 = new User("test2", 200);

        ts.addUser(u1);
        ts.addUser(u2);
//    Выполнение транзакции перевода (указаны идентификаторы пользователей и сумма перевода)
        ts.doTransaction(u1.getID(), u2.getID(), 100);

//    создаются две транзакции типа ДЕБЕТ/КРЕДИТ и
//    добавляются к получателю и отправителю.
//    ID обеих транзакций должны совпадать

        u1.getTransactions();
        u2.getTransactions();
    }
}
