package RoughClass;

import Trees.InOrder;
import Trees.PreOrder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

//    public class Rough {
//        int val;
//        Rough left;
//        Rough right;
//
//        public Rough() {
//        }
//
//        public Rough(int val) {
//            this.val = val;
//        }
//
//        public Rough(int val, Rough left, Rough right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
    }
//    public void add(int val){
//        root = addRecursive(root,val);
//    }
//    private Rough addRecursive(Rough currentNode, int val){
//        if(currentNode == null){
//            return new Rough(val);
//        }
//
//        if(val < currentNode.val){
//            currentNode.left = addRecursive(currentNode.left,val);
//        }
//        else if(val > currentNode.val){
//            currentNode.right = addRecursive(currentNode.right,val);
//        }
//        //Value Exists already
//        else{
//            return currentNode;
//        }
//
//        return currentNode;
//    }


    public class Rough {

        static boolean isLeaf(TreeNode root) {
            return root.left == null && root.right == null;
        }

        static void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
            TreeNode curr = root.left;
            if (curr == null) return;
            while (curr != null) {
                if (!isLeaf(curr)) res.add(curr.val);
                if (curr.left != null) curr = curr.left;
                else curr = curr.right;
            }
        }

        static void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
            TreeNode curr = root.right;
            ArrayList<Integer> temp = new ArrayList<>();
            if (curr == null) return;
            while (curr != null) {
                if (!isLeaf(curr)) temp.add(curr.val);
                if (curr.right != null) curr = curr.right;
                else curr = curr.left;
            }

            for (int i = temp.size() - 1; i >= 0; i--) {
                res.add(temp.get(i));
            }
        }

        static void addLeaves(TreeNode root, ArrayList<Integer> res) {
            if (isLeaf(root)) {
                res.add(root.val);
                return;
            }
            if (root.left != null) addLeaves(root.left, res);
            if (root.right != null) addLeaves(root.right, res);
        }

        static ArrayList<Integer> printBoundary(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();

            if (root == null) {
                return res;
            }
            res.add(root.val);
            addLeftBoundary(root, res);
            addLeaves(root, res);
            addRightBoundary(root, res);
            return res;
        }

        public static void main(String[] args) {

//            Tree tree = new TreeNode();

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(3);
            root.left.left.right = new TreeNode(4);
            root.left.left.right.left = new TreeNode(5);
            root.left.left.right.right = new TreeNode(6);
            root.right = new TreeNode(7);
            root.right.right = new TreeNode(8);
            root.right.right.left = new TreeNode(9);
            root.right.right.left.left = new TreeNode(10);
            root.right.right.left.right = new TreeNode(11);

            ArrayList<Integer> boundaryTraversal;
            boundaryTraversal = printBoundary(root);

            System.out.println("The Boundary Traversal is : ");
            for (int i = 0; i < boundaryTraversal.size(); i++) {
                System.out.print(boundaryTraversal.get(i) + " ");
            }
        }
    }

