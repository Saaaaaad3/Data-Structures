package Trees;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

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
    public void Display(Node currNode){

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> st = new Stack<>();

//        st.push(currNode);

        while(true){
            if(currNode != null){
                st.push(currNode);
                currNode = currNode.left;
            }
            else{
                if(st.isEmpty()) break;

                currNode = st.peek();
                result.add(currNode.val);
                st.pop();
                currNode = currNode.right;
            }
        }

        for(int i=0;i<result.size();i++){
            System.out.print("-" + result.get(i));
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
