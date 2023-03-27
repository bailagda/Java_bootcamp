package ex03;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        User niko = new User("Niko", 3000);
        User misha = new User("Misha", 2000);
        User julie = new User("Juli", 1000);

        System.out.println(niko);
        System.out.println(misha);
        System.out.println(julie);

//        Create transactions
        Transaction t1 = new Transaction(niko, misha);
        t1.setTransferAmount(1000);
        t1.printData();
        System.out.println(t1);

        Transaction t2 = new Transaction(niko, misha);
        t2.setTransferAmount(-500);
        t2.printData();
        System.out.println(t2);

        Transaction t3 = new Transaction(misha, julie);
        t3.setTransferAmount(200);
        t3.printData();
        System.out.println(t3);

        Transaction t4 = new Transaction(misha, julie);
        t4.setTransferAmount(-1000);
        t4.printData();
        System.out.println(t4);

//        Add transactions
        TransactionsLinkedList tl = new TransactionsLinkedList();
        tl.addTransaction(t1);
        tl.addTransaction(t2);
        tl.addTransaction(t3);
        tl.addTransaction(t4);
        tl.print();
        tl.removeById(t1.getId());

        System.out.println("\nПосле удаления");
        tl.print();
        // to arr
        Transaction[] arr = tl.transformToArr();
        System.out.println(Arrays.toString(arr));
    }
}
