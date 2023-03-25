package ex00;

public class User{
    private int ID;
    private String name;
    private int balance;
    
    protected User(){
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance > 0) {
            this.balance = balance;
        }
    }
    public void printData(){
        System.out.printf("ID:%d, %s, balance = %d\n", ID, name, balance);
    }
}
