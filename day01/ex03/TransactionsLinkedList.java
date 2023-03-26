package ex03;

import java.util.UUID;

public class TransactionsLinkedList
        implements TransactionsList {
    TransactionNode head;
    private int len = 0;
    @Override
    public void AddTransaction(Transaction newTransaction) {
        TransactionNode newNode = new TransactionNode(newTransaction);
        if(head != null) {
            newNode.next = head;
            newNode.prev = null;
        }
        head = newNode;
        ++len;
    }

    @Override
    public void RemoveById(UUID id) {

    }

    @Override
    public void TransformToArr() {

    }
}
