
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
        CLL.insertAtIndex(5,4);
        System.out.println(CLL.Size());
        System.out.println(CLL.CycleExists());

        CLL.Display(20);

    }
}
