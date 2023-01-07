
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args){

        System.out.println();
        SinglyLinkedLists LL = new SinglyLinkedLists();

        LL.insertFirst(1);
        LL.insertFirst(2);
        LL.insertLast(3);
        LL.insertLast(4);
        LL.insertLast(5);
        LL.DeleteByValue(4);

        LL.Display();

    }
}
