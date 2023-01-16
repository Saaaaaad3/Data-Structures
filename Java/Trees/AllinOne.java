package Trees;

//PreOrder Inorder and PostOrder in Single Traversal

import java.util.List;
import java.util.Stack;

public class AllinOne {
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
    public class Pair{
        Node node;
        int num;

        Pair(Node _node, int _num){
            num = _num;
            node = _node;
        }
    }

    public void AllTraversal(Node root, List<Integer> pre, List<Integer> in, List<Integer> post){
        Stack<Pair> st = new Stack<>();

        st.push(new Pair(root,1));

        if(root == null) return;

        while(!st.isEmpty()){
            Pair it = st.pop();

            if(it.num == 1){
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left,1));
                }
            }

            else if(it.num == 2){
                it.num++;
                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right,1));
                }
            }
            else{
                post.add(it.node.val);
            }
        }
    }
}
