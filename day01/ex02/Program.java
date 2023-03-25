package ex02;

public class Program {
    public static void main(String[] args) {
        User niko = new User("Niko", 2000);
        User viki = new User("Viki", 2000);
        User yoko = new User("Yoko", 2000);
        User lori = new User("Lori", 2000);

        UsersArrayList list = new UsersArrayList();
        list.AddUser(niko);
        list.AddUser(viki);
        list.AddUser(yoko);
        list.AddUser(lori);

        User test1 = list.findUserID(niko.getID());
        test1.printData();
        User test2 = list.findUserIndex(2);
        test2.printData();
        int test3 = list.NumberOfUsers();
        System.out.println(test3);
        User testException = list.findUserIndex(5);
    }
}
