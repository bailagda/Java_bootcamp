package ex00;

public class Program {
    public static void main(String[] args) {
        User sender = new User();
        sender.setID(0);
        sender.setName("Lupa");
        sender.setBalance(500);
        sender.printData();

        User racipient = new User();
        racipient.setID(1);
        racipient.setName("Pupa");
        racipient.setBalance(400);
        racipient.printData();

        Transaction trans = new Transaction();
        trans.setSender(sender);
        trans.setRecipient(racipient);
        trans.setTransferAmount(-200);
        trans.printData();
    }
}
