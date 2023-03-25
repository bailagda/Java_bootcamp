package ex01;

public class Program {
    public static void main(String[] args) {
        User joe = new User("Joe", 2000);
        User nano = new User("Nano", 3000);
        User vim = new User("Vim", 4000);

        joe.printData();
        vim.printData();
        nano.printData();
    }

}
