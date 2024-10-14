import java.util.Scanner;

public class T_BinaryTree {
    private Node root;
    public class Node {
        private Node left;
        private Node right;
        private  int value;

        public Node(int value) {
            this.value = value;
        }
    }
    ///as it in pre-order, the root will call first and then left, then right,
    //creating a root node for the tree and calling for a function to create others node of the tree
    public void populate(Scanner scanner) {
        System.out.print("Enter the root node : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    //for creating a tree
    public void populate(Scanner scanner, Node node) {
        //for creating the left side of node as it in preorder traverse
        System.out.print(STR." Do you want to create a Node on left of \{node.value}"+": ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print(STR."Enter the left node \{node.value}"+": ");
            int value = scanner.nextInt();
            node.left  = new Node(value);
            populate(scanner,  node.left );
        }
        //for creating the right side of node as it in preorder traverse
        System.out.print(STR." Do you want to create a Node on right of \{node.value}"+": ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print(STR."Enter the right node \{node.value}"+": ");
            int value = scanner.nextInt();
            node.right  = new Node(value);
            populate(scanner,  node.right );
        }
    }

    //it makes sure to take the root node first as in pre-order
    public void display()
    {
        display(root,"");
    }
    //it stores the element of tree in store string
    private void display(Node node,String store) {
        //if no node present then return the function calling
        if (node == null)
            return;
        System.out.println(store + node.value);
        //to store the element of left
        display(node.left , store + "\t");
        //to store the element of right
        display(node.right , store + "\t");
    }

    //anothe way of display
    public void display2()
    {
        display2(root,1);
    }

    public void display2(Node node, int level)
    {
        //if no node present then return the function calling
        if (node == null)
            return;

        display2(node.right , level + 1 );

        if (level != 0) {
            for (int i = 0; i <level -1 ; i++)
                System.out.print("|\t\t");
            System.out.println("|--->" + node.value);
        }
        else
            System.out.println(node);
        display2(node.left , level + 1 );
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T_BinaryTree tree =new T_BinaryTree();
        tree.populate(scanner);
        tree.display();
        tree.display2();
        System.out.println("BYE BYE.................. (>^_^<)");
    }
}