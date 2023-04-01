package ex05;

import java.util.Objects;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private User recipient;
    private User sender;
    private String category;
    private Integer amount;
    
    Transaction(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
        this.id = UUID.randomUUID();
    }
    Transaction(Transaction other) {
        this.setID(other.id);
        this.setRecipient(other.recipient);
        this.setSender(other.sender);
    }

    public UUID getId() {
        return(this.id);
    }
    public void setRecipient(User r){
        recipient = r;
    }
    public void setSender(User s){
        sender = s;
    }
    public int getAmount() {
        return amount;
    }

    public void setTransferAmount(int amount) throws IllegalTransactionException {
        if(Math.abs(amount) > sender.getBalance()) {
            throw new IllegalTransactionException();
        } else {
            this.amount = amount;
            if(amount < 0) {
                this.category = "OUTCOME";
            } else { this.category = "INCOME";}
        }
    }

    private void setID(UUID id) {
        this.id = id;
    }

    public void printData() {
        if(Objects.equals(category, "INCOME")) {
            System.out.printf("%s -> %s, %d, %s, transaction %s\n",
                    sender.getName(), recipient.getName(), amount, category, id.toString());
        } else {
            System.out.printf("%s -> %s, %d, %s, transaction %s\n", recipient.getName(),
                    sender.getName(), amount, category, id.toString());
        }
    }
    public void printData(int userId) {
        if(Objects.equals(category, "INCOME")) {
            if(recipient.getID() == userId) {
                System.out.printf("To %s(id = %d) with id = %s, transaction %s\n",
                        recipient.getName(), userId, amount, id.toString());
            }
        } else {
            if(sender.getID() == userId) {
                System.out.printf("To %s(id = %d) with id = %s, transaction %s\n",
                        sender.getName(), userId, amount, id.toString());
            }
        }
    }

}
