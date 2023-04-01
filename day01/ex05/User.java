package ex05;

public class User {
    private final int ID;
    private String name;
    private int balance;
    private TransactionsLinkedList transactionHistory = new TransactionsLinkedList();
    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
        ID = UserIdsGenerator.getInstance().generateId();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(this.balance > 0) {
            this.balance = balance;
        }
    }

    public void addTransfer(Transaction t) {
        transactionHistory.addTransaction(t);
    }
    public void printData(){
        System.out.printf("ID:%d, %s, balance = %d\n", ID, name, balance);
    }
    public TransactionsLinkedList getTransactions() {
        return(transactionHistory);
//        transactionHistory.print();
    }

}
