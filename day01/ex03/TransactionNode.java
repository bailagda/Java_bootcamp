package ex03;

public class TransactionNode {
    private Transaction t;
    TransactionNode next;
    TransactionNode prev;

    TransactionNode(Transaction t) {
        this.t = t;
    }

}
