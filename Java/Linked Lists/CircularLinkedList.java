public class CircularLinkedList {

    private int size;
    private Node head;
    private Node tail;
    public class Node {
        public int value;
        public Node next;

        private Node() {}

        private Node(int num) {
            this.value = num;
        }
    }

    public int Size(){
        return size;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);

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

    public void insertLast(int value){
        Node newNode = new Node(value);

        if(head == null){
            insertFirst(value);
            return;
        }
        tail.next = newNode;
        newNode.next = null;
        tail = newNode;
    }
    public void insertAtIndex(int num, int index) {

        if (head == null && index != 0) {
            System.out.println("List is Empty");
            return;
        }
        if (index == 0) {
            insertFirst(num);
            return;
        }
        if(index == size-1){
            insertLast(num);
            return;
        }
        if (index > size) {
            System.out.println("index exceeds the size of the list");
            return;
        }
        Node tempNode = head;
        Node newNode = new Node(num);
        while (index - 1 > 0) {
            tempNode = tempNode.next;
            index--;
        }
        if (tempNode.next == null) {
            newNode.next = null;
        } else {

            newNode.next = tempNode.next;
        }
        tempNode.next = newNode;
        size++;

    }

    public void Display(int max){
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        Node tempNode = head;
        int count = 0;

        while(tempNode != null && max > count){
            System.out.print(tempNode.value + "->");
            tempNode = tempNode.next;
            count++;
        }
        System.out.print("End");
    }

    public boolean CycleExists() {
        if (head == null) {
            System.out.println("List is Empty");
            return false;
        }
        return PointersMeet(head) != null;
    }

    private Node PointersMeet(Node head) {
        Node fastPtnr = head;
        Node slowPtnr = head;

        do {
            if (fastPtnr.next == null || fastPtnr.next.next == null) {
                return null;
            }

            slowPtnr = slowPtnr.next;
            fastPtnr = fastPtnr.next.next;
        }
        while (slowPtnr != fastPtnr);

        return slowPtnr;
    }



}
