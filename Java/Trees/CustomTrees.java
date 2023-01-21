package Trees;

public class CustomTrees {
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

    public int DepthOfBinaryTree(Node root){
        if(root == null){
            return 0;
        }
        int left = DepthOfBinaryTree(root.left);
        int right = DepthOfBinaryTree(root.right);

        return 1+Math.max(left, right);
    }

    public boolean isBalanced(Node root) {
        return heightOfTree(root) != -1;
    }

    public int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int left = heightOfTree(root.left);
        if(left == -1) return -1;

        int right = heightOfTree(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1){
            return -1;
        }
        return 1+ Math.max(left,right);
    }
}
