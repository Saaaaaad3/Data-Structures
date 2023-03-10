package Trees;

import java.util.Stack;

public class PreOrder {

    Node root;

    public static class Node {
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
        //Value Exists already
        else{
            return currentNode;
        }

        return currentNode;
    }
    public void DisplayRec(Node node){

        if(node != null) {
            System.out.println(" " + node.val);
            DisplayRec(node.left);
            DisplayRec(node.right);
        }
    }

    public void Display(Node root){
        if(root == null){
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            root = st.pop();
            System.out.println(root.val);
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
    }


}
