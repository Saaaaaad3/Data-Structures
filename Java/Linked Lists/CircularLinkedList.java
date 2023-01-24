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

    public void insertLast(int num) {

        Node node = new Node(num);
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



}
