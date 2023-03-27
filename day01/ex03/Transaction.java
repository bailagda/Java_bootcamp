package ex03;
import ex03.User;

import java.util.Objects;
import java.util.UUID;

public class Transaction {
    private final UUID id;
    private User recipient;
    private User sender;
    private String category;
    private Integer amount;
    
    Transaction(User sender, User recipient) {
        this.sender = sender;
        this.recipient = recipient;
        this.id = UUID.randomUUID();
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
    public void setTransferAmount(int amount) {
        if(Math.abs(amount) > sender.getBalance()) {
            throw new ArithmeticException();
        } else {
            this.amount = amount;
            if(amount < 0) {
                this.category = "OUTCOME";
            } else { this.category = "INCOME";}
        }
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
}
