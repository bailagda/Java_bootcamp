package ex05;

public class UserNotFoundException extends RuntimeException {

    @Override
    public String toString() {
        String message = "User does not exist!";
        System.out.println(message);
        return message;
    }

}
