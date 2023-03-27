package ex03;

import java.util.UUID;

public class TransactionsLinkedList
        implements TransactionsList {
    TransactionNode head;
    private int len = 0;
    @Override
    public void addTransaction(Transaction newTransaction) {
        TransactionNode newNode = new TransactionNode(newTransaction);
        if(head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        ++len;
    }

    @Override
    public void removeById(UUID id) {
        TransactionNode curr = head;
        for(int i = 0; i != len; ++i) {
            if(curr.getT().getId() == id) {
                if(curr.next != null && curr.prev != null) {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                } else if(curr.next != null) {
                    curr.next.prev = null;
                } else if(curr.prev != null) {
                    curr.prev.next = null;
                }
                curr.next = curr.prev = null;
                --len;
                break;
            }
            curr = curr.next;
        }
    }

    @Override
    public Transaction[] transformToArr() {
       Transaction[] arr = new Transaction[len];
       TransactionNode curr = head;
       for(int i = 0; i < len; ++i) {
           arr[i] = curr.getT();
           curr = curr.next;
       }
       return arr;
    }

    void print() {
        TransactionNode currentNode = head;
        while(currentNode != null) {
            currentNode.getT().printData();
            currentNode = currentNode.next;
        }
    }
}
