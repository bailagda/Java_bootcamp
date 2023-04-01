package ex05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private TransactionsService t = new TransactionsService();
    private String mode = "";

    Menu(String mode){
        this.mode = mode;
    }

    public void start() {
        for(;;) {
            printMenu();
            getCommand();
            System.out.println("-------------------------------------------");
        }
    }
    public void printMenu() {
        System.out.println("1. Add a user\n" +
                        "2. View user balances\n" +
                        "3. Perform a transfer\n" +
                        "4. View all transactions for a specific user");
        if(mode.equals("--profile=dev")) {
            System.out.println("5. DEV – remove a transfer by ID\n" +
                            "6. DEV – check transfer validity");
        }
        System.out.println("7. Finish execution\n");
    }

    public void getCommand() {
        Scanner scan = new Scanner(System.in);
        try {
           int command  = scan.nextInt();
           switch (command) {
                case(1):
                    addUser();
                    break;
                case(2):
                    System.out.println("Enter a user ID");
                    User u = t.getUser(scan.nextInt());
                    System.out.printf("%s - %d\n", u.getName(), u.getBalance());
                    break;
                case(3):
                    System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
                    t.doTransaction(scan.nextInt(), scan.nextInt(), scan.nextInt());
                    System.out.println("The transfer is completed\n");
                    break;
                case(4):
                    System.out.println("Enter a user ID");
                    User u1 = t.getUser(scan.nextInt());
                    t.getTransList().print(u1.getID());
                    break;
                case(5):
                    if(mode.equals("--profile=dev")) {
                        System.out.println("Enter a user ID and a transfer ID");
                        String[] userData = scan.nextLine().split(" ");
                        t.removeTransaction(userData);
                        User u2 = t.getUser(Integer.valueOf(userData[0]));
                        System.out.printf("Transfer To %s(id = %s) %d removed",
                                u2.getName(), userData[0],
                                u2.getTransactions().findTransaction(userData[1]));
                    } else {
                        System.out.println("Option not available");
                    }
                    break;
                case(6):
                    if(mode.equals("--profile=dev")) {
                    } else {
                        System.out.println("Option not available");
                    }
                    break;
                case(7):
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option does not exist");
                    break;
        }
        } catch(InputMismatchException e) {
            System.out.println("ERROR: Wrong command");
        } catch (IllegalTransactionException e) {
            System.out.println("ERROR: Operation cannot be performed");
        }
    }

    private void addUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a user name and a balance");
        String[] userData = scan.nextLine().split(" ");
        User newUser = new User(userData[0], Integer.valueOf(userData[1]));
        t.addUser(newUser);
        System.out.printf("User with id = %d is added\n", newUser.getID());
    }
}
