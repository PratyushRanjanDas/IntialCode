public class T_BinarySearchTree {
    public class Node{
        private Node left;
        private Node right;
        private int value;
        private int heigth;
        //to intialize the value in node
        public Node (int value)
        {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
    private Node root;
    //to get a node and return heigth from the root with respect to that Node
    public int heigth(Node node)
    {
        if (node == null) {
            return -1;
        }
        return node.heigth;
    }

    //to check if the node is empty/not
    public boolean isEmpty()
    {
        return  root == null;
    }

    //to display the elements of tree command it to start from root
    public void display()
    {
        display(root,"root node");
    }
    //display the whole left and right side.
    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());
        //display the left side of the node.
        display(node.left, "left child of" + node.getValue() + ":");
        //display the right side of the node.
        display(node.right, "right child of" + node.getValue() + ":");
    }
    /*Here how this populates work
                 -5-
                |   |
                2   ?
                 Let say you want to add a no greater than 5 on?
                 For right-side insertion in a binary search tree,
                 compare the value with the current node's value.
                  Recursively insert into the right subtree if the value is greater,
                  initializing a new node if necessary.
        VICE VERSA FOR LEFT
    */
    public void insertion(int[] ARR) {
        for (int value : ARR) {
            this.populate(value);
        }
    }

    public void populate(int value) {
        root = populate(value, root);
    }

    private Node populate(int value, Node node) {
        if (node == null) {
            // Create a new node and initialize its height to 0
            return new Node(value); // height will be updated later
        }

        // Insert into left or right subtree based on value comparison
        if (value < node.value) {
            node.left = populate(value, node.left);
        } else if (value > node.value) {
            node.right = populate(value, node.right);
        }
        // If the value is equal, do nothing (no duplicates)

        // Update the height of the current node
        node.heigth = Math.max(heigth(node.left), heigth(node.right)) + 1;
        return node;
    }


    //to sort the given array
    public void populatesortar(int[] arr)
    {
        populatesortar(arr,0,arr.length);
    }
public void populatesortar(int[] arr, int start, int end)
{
    if (start >= end) {
        return;
    }
    int mid = (start + end)/2;
    this.populate(arr[mid]);
    populatesortar(arr, start, mid);
    populatesortar(arr, mid+1, end);
}

    //to check if BST is balanced or not
    public boolean balanced()
    {
        return balanced(root);
    }
    public boolean balanced(Node node)
    {
        if (node == null) {
            return true;
        }
        return Math.abs(heigth(node.left) - heigth(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public static void main(String[] args) {
        T_BinarySearchTree tree = new T_BinarySearchTree();
        int[] ARR = {1,2,3,4,5,6,7};
        tree.populatesortar(ARR);
        tree.display();
    }
}


