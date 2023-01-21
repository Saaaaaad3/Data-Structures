public class DoublyLinkedLists {
    private static int size;
    private ListNode head;
    private ListNode tail;

    public DoublyLinkedLists() {
        size = 0;
    }
    public class ListNode {
        private int value;
        private ListNode next;
        private ListNode prev;

        private ListNode() {
        }

        private ListNode(int value) {
            this.value = value;
        }

        private ListNode(int value, ListNode next, ListNode prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    public int Size() {
        return size;
    }
    public void insertFirst(int num){

        ListNode node = new ListNode(num);

        if(head == null){
            head = node;
            tail = node;
            size--;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        head.prev = null;

        size++;
    }
    public void insertLast(int num) {
        ListNode node = new ListNode(num);
        if(head == null){
            insertFirst(num);
            return;
        }
        if(tail != null){
            node.prev = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }
        size++;
    }
    public void Display(){
        ListNode tempHead = head;
        while(tempHead != null){
            System.out.print(tempHead.value + "->");
            tempHead = tempHead.next;
        }
        System.out.println("End");
    }
    public void DisplayReverse(){
        if(tail == null){
            System.out.println("List is Empty");
        }
        ListNode tempHead = tail;
        while(tempHead != null){
            System.out.print(tempHead.value + "->");
            tempHead = tempHead.prev;
        }
        System.out.println("End");
    }
    public void DeleteFirst(){
        if(head == null){
            System.out.println("The List is Empty");
            return;
        }
        head = head.next;
        size--;
    }
    public void DeleteLast(){
        if(tail == null){
            System.out.println("The List is Empty");
            return;
        }
        tail = tail.prev;
        size--;
    }
    public void Delete(int num){
        if(head == null){
            System.out.println("The List is Empty");
        }
        ListNode tempHead = head;

        do{
            if(tempHead.value == num){
                if(tempHead == head){
                    DeleteFirst();
                    size--;
                    return;
                }
                if(tempHead == tail){
                    DeleteLast();
                    size--;
                    return;
                }
                tempHead.prev.next = tempHead.next;
                tempHead.next.prev = tempHead.prev;
            }
            tempHead = tempHead.next;
        }
        while(tempHead != null);

        size--;

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
    public void reverseList(){

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
