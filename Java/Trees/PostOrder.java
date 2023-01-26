package Trees;

public class PostOrder {
    Node root = new Node();

    public class Node{
        int val;
        InOrder.Node left;
        InOrder.Node right;

        public Node(){}
        public Node(int val){
            this.val = val;
        }
        public Node(int val, InOrder.Node left, InOrder.Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
