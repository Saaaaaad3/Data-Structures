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
        ListNode tempHead = tail;
        while(tempHead != null){
            System.out.print(tempHead.value + "->");
            tempHead = tempHead.prev;
        }
        System.out.println("End");
    }

}
