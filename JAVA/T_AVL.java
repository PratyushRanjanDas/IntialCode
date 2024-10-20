import javax.xml.crypto.NodeSetData;
import java.util.Scanner;

public class T_AVL {
    public class Node {
        private Node left;
        private Node right;
        private int value;
        private int height;

        public Node(int value) {
            this.value = value;
            this.height = 0; // Initialize height to 0 when a new node is created
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, "Left child of " + node.getValue() + ": ");
        display(node.right, "Right child of " + node.getValue() + ": ");
    }

    public void insertion(int[] arr) {
        for (int value : arr) {
            root = populate(value, root);
        }
    }
    public void populate(int value) {
        root = populate(value, root);
    }
    private Node populate(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = populate(value, node.left);
        } else if (value > node.value) {
            node.right = populate(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                return rightRotate(node); // Left-Left case
            } else {
                node.left = leftRotate(node); // Left-Right case
                return rightRotate(node);
            }
        }

        if (height(node.right) - height(node.left) > 1) {
            if (height(node.right.right) >= height(node.right.left)) {
                return leftRotate(node); // Right-Right case
            } else {
                node.right = rightRotate(node); // Right-Left case
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;
        c.right = p;
        p.left = t;
        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node t = c.left;
        c.left = p;
        p.right = t;
        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);
        return c;
    }

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

    public void populatesortar(int[] arr) {
        populatesortar(arr, 0, arr.length);
    }

    private void populatesortar(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        this.populate(arr[mid]);
        populatesortar(arr, start, mid);
        populatesortar(arr, mid + 1, end);
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 &&
                balanced(node.left) && balanced(node.right);
    }

    public static void main(String[] args) {
        T_AVL tree = new T_AVL();
        for (int i = 0; i < 10; i++) {
            tree.populate(i);
        }

        System.out.println("Height of the AVL tree: " + tree.height());
        tree.display();
        tree.display2();
    }
}
