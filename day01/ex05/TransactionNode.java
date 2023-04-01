package ex04;

public class TransactionNode {
    private Transaction t;
    TransactionNode next;
    TransactionNode prev;

    TransactionNode(Transaction t) {
        this.t = t;
    }

    public Transaction getT() {
        return t;
    }
}
