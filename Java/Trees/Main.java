package Trees;

public class Main {
    public static void main(String[] args){
        PreOrder PreTree = new PreOrder();
        InOrder InTree = new InOrder();
//        PreOrder.Node root = new PreOrder.Node(6);


        InTree.add(1);
        InTree.add(4);
        InTree.add(2);
        InTree.add(8);
        InTree.add(3);
//        InTree.add(5);
//        InTree.add(7);
//        InTree.add(6);

        System.out.println("Root: "+InTree.root.val);
//        InTree.DisplayRec(InTree.root);
        System.out.println();
        InTree.Display(InTree.root);


    }
}

