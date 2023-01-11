package Trees;

public class Main {
    public static void main(String[] args){
        PreOrder tree = new PreOrder();

//        PreOrder.Node root = new PreOrder.Node(6);


        tree.add(4);
        tree.add(1);
        tree.add(2);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);

        System.out.println("Root: "+tree.root.val);
        tree.DisplayRec(tree.root);
        System.out.println();
        tree.Display(tree.root);


    }
}

