
public class SinglyLinkedLists {

    private static int size;
    private ListNode head;
    private ListNode tail;

    public SinglyLinkedLists() {
        size = 0;
    }

    public class ListNode {
        private int value;
        private ListNode next;

        private ListNode() {
        }

        private ListNode(int value) {
            this.value = value;
        }

        private ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public int Size() {
        return size;
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);

        if (head == null) {
            head = newNode;
            tail = head;
            head.next = null;

            size++;
            return;
        }
        newNode.next = head;
        head = newNode;

        size++;
    }

    public void insertLast(int num) {

        ListNode node = new ListNode(num);
        if(head == null){
            insertFirst(num);
            return;
        }
        if(tail != null){
            node.next = null;
            tail.next = node;
            tail = node;
            size++;
        }
    }
    public void DeleteByValue(int value) {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        if (head.value == value) {
            head = head.next;
            size--;
            return;
        }

        ListNode tempHead = head;
        while (tempHead != null && tempHead.next != null){
            if(tempHead.next.value == value){
                tempHead.next = tempHead.next.next;
                size--;
                return;
            }
            tempHead = tempHead.next;
        }
    }

    public void makeCycle(int index) {
        if (tail == null) {
            System.out.println("Tail is Null");
            return;
        }
        if (size < index) {
            System.out.println("Index bigger than List size");
            return;
        }

        ListNode tempHeadPtnr = head;
        while (index != 0) {
            tempHeadPtnr = tempHeadPtnr.next;
            index--;
        }
        tail.next = tempHeadPtnr;

    }

    public void Display(){
        ListNode tempHead = head;
        while(tempHead != null){
            System.out.print(tempHead.value + "->");
            tempHead = tempHead.next;
        }
        System.out.println("End");
    }

    public void Display(int count) {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        ListNode tempHeadPntr = head;
        System.out.print(tempHeadPntr.value + "->");

        while (tempHeadPntr.next != null && count > 0) {
            tempHeadPntr = tempHeadPntr.next;
            if (tempHeadPntr == tail) {
                System.out.print("'" + tempHeadPntr.value + "'" + "->");
            } else {
                System.out.print(tempHeadPntr.value + "->");

            }
            count--;
        }
        System.out.println("End");
    }

    public boolean DetectCycle() {
        if (head == null) {
            System.out.println("List is Empty");
            return false;
        }
        if (PointersMeet(head) == null)
            return false;

        return true;
    }

    public ListNode PointersMeet(ListNode head) {
        ListNode fastPtnr = head;
        ListNode slowPtnr = head;

        do {
            if (slowPtnr.next == null || slowPtnr.next.next == null) {
                return null;
            }

            slowPtnr = slowPtnr.next;
            fastPtnr = fastPtnr.next.next;
        }
        while (slowPtnr != fastPtnr);

        return slowPtnr;
    }

    public int CycleLength() {
        int length = 0;

        if (!DetectCycle()) {
            System.out.println("No cycle present in the list");
            return length;
        }

        ListNode firstPntr = PointersMeet(head);
        ListNode secondPntr = firstPntr;

        do {
            firstPntr = firstPntr.next;
            length++;
        }
        while (firstPntr != secondPntr);

        return length;
    }

    public int detectCycle() {
        if (head == null || head.next == null) {
            return -1;
        }
        int cycleLength = CycleLength();

        ListNode firstPntr = head;
        ListNode secondPntr = head;

        while (cycleLength > 0) {
            secondPntr = secondPntr.next;
            cycleLength--;
        }

        while (firstPntr != secondPntr) {
            firstPntr = firstPntr.next;
            secondPntr = secondPntr.next;
        }
        return firstPntr.value;
    }

    public ListNode MergeSort() {
        return sortList(head);
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode mid = getMid(head);
        System.out.println(mid.value);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode tempHead = new ListNode();
        ListNode tail = tempHead;

        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 == null) ? list2 : list1;
        return tempHead.next;
    }

    public ListNode getMid(ListNode head) {
        ListNode midPrev = null;

        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }

        ListNode mid = midPrev.next;
        midPrev.next = null;

        return mid;
    }

    public void reverseList() {
        ListNode Pres = head;
        ListNode Prev = null;
        ListNode nxt = Pres.next;

        while (Pres != null) {
            Pres.next = Prev;
            Prev = Pres;
            Pres = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
        head = Prev;
    }

    public void reverseListTwo(int left, int right) {

        if (left == right) {
            return;
        }
        ListNode current = head;
        ListNode prev = null;
        ListNode nxt = head.next;

        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        for (int i = 0; i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
//        return head;

    }

    public boolean PalindromeLinkedList() {
        ListNode fast = head;
        ListNode slow = head;
        ListNode tempNode = head;
        ListNode resultNode = head;

        //Get Middle Element
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow;
        ListNode prev = null;
        ListNode nxt = slow.next;

        //Reverse The second half of list (From middle to end)
        while (mid != null) {
            mid.next = prev;
            prev = mid;
            mid = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
        ListNode headHolder = prev;

        //Compare start to middle and middle to end
        while (tempNode != null && prev != null) {
            if (tempNode.value != prev.value) {
                return false;
            }
            tempNode = tempNode.next;
            prev = prev.next;
        }

        //re-Reverse to maintain originality
        while (headHolder != null) {
            headHolder.next = prev;
            prev = headHolder;
            headHolder = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }

        return true;
    }

    public void reOrderList() {
        ListNode fast = head;
        ListNode slow = head;
        ListNode firstHalf = head;
        ListNode resultNode = head;

        //Get Middle Element
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow;
        ListNode prev = null;
        ListNode nxt = slow.next;

        //Reverse The second half of list (From middle to end)
        while (mid != null) {
            mid.next = prev;
            prev = mid;
            mid = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
        ListNode secondHalf = prev;
        //Take 1 by 1 and from both halves
        while (firstHalf != null && secondHalf != null) {

            ListNode temp = firstHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = temp;

            temp = secondHalf.next;
            secondHalf.next = firstHalf;
            secondHalf = temp;
        }
        if (firstHalf != null) {
            firstHalf.next = null;
        }
    }

    public void reverseKNodes(int k) {

        ListNode newHead = head;
        int listSize = 0;
        while (newHead != null) {
            newHead = newHead.next;
            listSize++;
        }

        ListNode prev = null;
        ListNode current = head;

        while (listSize >= k) {

            ListNode last = prev;
            ListNode newEnd = current;

            ListNode nxt = current.next;

            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = nxt;
                if (nxt != null) {
                    nxt = nxt.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = current;

            if (current == null) {
                break;
            }
            prev = newEnd;
            listSize -= k;
        }
//        return head;
    }

    public ListNode DetermineStartOfCycle(ListNode head) {

        //Check if list size is more than 1
        if(head == null || head.next == null){
            return null;
        }

        //Check if there is cycle in list
        ListNode meetPoint =  CheckForCycle(head);
        if(meetPoint == null){
            return null;
        }

        //Get length of the cycle
        int cycleLength = GetCycleLength(meetPoint);

        //Determine the starting of cycle
        ListNode startNode = DetermineStartOfCycle(head, cycleLength);
        return startNode;
    }

    public ListNode DetermineStartOfCycle(ListNode head,int cycleLength){
        ListNode first = head;
        ListNode second = head;

        while(cycleLength-- > 0){
            first = first.next;
        }

        while(first != second){
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public int GetCycleLength(ListNode meetPoint){
        int cycleLength = 0;
        ListNode temp = meetPoint;

        do{
            temp = temp.next;
            cycleLength++;
        }
        while(temp != meetPoint);

        return cycleLength;
    }

    public ListNode CheckForCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        slow = slow.next;
        fast = fast.next.next;

        do{
            if(slow == null || slow.next == null){
                return null;
            }
            slow = slow.next;

            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
        }
        while(fast != slow);

        return fast;
    }
}