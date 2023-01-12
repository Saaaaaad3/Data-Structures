package Trees;

public class InOrder {
    Node root = new Node();
    public class Node{
        int val;
        Node left;
        Node right;

        public Node(){}
        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void add(int val){
        root = addRecursive(root,val);
    }

    public void DisplayRec(Node root){
        if(root != null){
            DisplayRec(root.left);
            System.out.print(root.val + "-");
            DisplayRec(root.right);
        }
    }
    private Node addRecursive(Node currentNode, int val){
        if(currentNode == null){
            return new Node(val);
        }
        if(val < currentNode.val){
            currentNode.left = addRecursive(currentNode.left,val);
        }
        else if(val > currentNode.val){
            currentNode.right = addRecursive(currentNode.right,val);
        }
        else{
            //Value Already Exists
            return currentNode;
        }
        return currentNode;
    }

}
