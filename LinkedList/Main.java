import LinkedListQuestions.DetectStartOfCycle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args){

        System.out.println();
        SinglyLinkedList LL = new SinglyLinkedList();

        LL.insertFirst(3);
        LL.insertFirst(2);
        LL.insertFirst(1);
        LL.insertLast(4);
        LL.insertLast(5);
        LL.insertLast(6);

//        LL.MergeSort();
//        LL.reverseList();
//        LL.makeCycle(4);

//        LL.insertLast(1);
//        LL.insertLast(2);
//        LL.insertLast(3);
//        LL.insertLast(4);
//        LL.insertLast(5);

        LL.Display(20);
//        LL.reverseKNodes(3);
//        LL.Display(20);


//        System.out.println("Cycle Starts at :" + LL.detectCycle());

//        boolean isCycle = LL.DetectCycle();
//
//        if(!isCycle)
//            System.out.println("Size:" + LL.Size());
//
//        System.out.println("Cycle Detected: "+ isCycle);
//        if(isCycle)
//            System.out.println("Cycle Length:" + LL.CycleLength());


    }
}
