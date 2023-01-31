
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args){

        System.out.println();
        CircularLinkedList CLL = new CircularLinkedList();

        CLL.insertFirst(1);
        CLL.insertFirst(2);
        CLL.insertFirst(3);
        CLL.insertFirst(4);
        System.out.println(CLL.Size());
        CLL.insertAtIndex(5,4);
//        System.out.println(CLL.CycleExists());
//        System.out.println(CLL.CycleExists());

        CLL.DisplayWithLimit(20);
        CLL.makeCycleAt(1);
        CLL.DisplayWithLimit(20);

    }
}
