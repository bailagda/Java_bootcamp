package ex04;

public class IllegalTransactionException extends Throwable {
    @Override
    public String toString() {
        String message = "User does not exist!";
        System.out.println(message);
        return message;
    }

}
