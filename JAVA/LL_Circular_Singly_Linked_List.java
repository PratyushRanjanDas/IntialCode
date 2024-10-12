import java.util.Scanner;

public class LL_Circular_Singly_Linked_List {
    private Node head;
    private  int size;
    public LL_Circular_Singly_Linked_List()
    {
        this.size = 0;
    }
    public  class Node
    {
        private Node next;
        private int value;

        public  Node (int value)
        {
            this.value = value;
        }

        public  Node (int value , Node next )
        {
            this.value = value;
            this.next = next;
        }
    }

    void insertBegin(int value)
    {
        Node node = new Node(value);
        //if there's no node
        if (head == null) {
            head = node;
            node.next = node;
        }
        // if there already a node
        else
        {
            node.next = head;
            Node temp = head;
            while(temp.next != head)
                temp = temp.next;
            temp.next = node;
            head = node;
        }
        size++;
    }

    public void insertEnd(int value) {
        Node node = new Node(value);  // Create a new node

        // Handle an empty list case efficiently
        if (head == null) {
            head = node;
            node.next = head;  // Set the next pointer for a circular linked list
            return;
        }

        // Efficiently find the last node (handling a circular list)
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        // Update last node's next and new node's next (circular)
        temp.next = node;
        node.next = head;
        size++;                 // Increment size
    }

    void insertPos(int value,int pos)
    {
        if (pos<1 || pos>size)
            System.out.println("invalid position ");
        else if (pos==1)
            insertBegin(value);
        else if (pos==size)
            insertEnd(value);
        else
        {
            Node node = new Node(value);
            Node temp = head;
            for (int i = 1; i < pos-1; i++) 
                temp = temp.next;
            node.next = temp.next;
            temp.next=node;
            size++;
        }
    }

    void Display(){
        if (head == null) {
            System.out.println(" there is no node in List");
            return;
        }
        Node temp = head;
        int x = size;
        System.out.println("Size: " + x);
        System.out.print("[");
        //for the first ele
        System.out.print(" " + temp.value);
        temp = temp.next;

        // Loop until we reach the head again (but print this time)
        while (temp != head){
            System.out.print(" " + temp.value);
            temp=temp.next;
        }
        System.out.println(" ]");
    }

    void deleteBegin()
    {
        //if there is no node
        if (head == null) {
            System.out.println(" there is no node in List");
            return;
        }
        // if there is 0ne node only
        if (head == head.next) {
            head.next = null;
            head = null;
        }
        // if there is more than one node
        else
        {
            Node temp = head;
            while(temp.next != head)
                temp = temp.next;
            head = head.next;
            temp.next.next = null;
            temp.next = head;
        }
        size--;
    }

    void deleteEnd()
    {
        //if there is no node
        if (head == null) {
            System.out.println(" there is no node in List");
            return;
        }
        // if there is 0ne node only
        if (head == head.next) {
            head.next = null;
            head = null;
        }
        // if there is more than one node
        else
        {
            Node temp = head;
            while (temp.next.next != head)
                temp = temp.next;
            temp.next.next = head;
            temp.next = head;
        }
        size--;
    }

    void  deletePos(int pos)
    {
        //if there is no node
        if (head == null) {
            System.out.println(" there is no node in List");
            return;
        }
        // if pos is less than 1 or greater than size then it consider as an invalid pos
        if (pos < 1 || pos > size-1)
            System.out.println(" invalid position ");
        // if delete at beginning
        else if (pos == 1)
            deleteBegin();
        // if delete at end
        else if (pos == size)
            deleteEnd();
        // if delete at middle/internal position
        else
        {
            Node temp = head;
            for (int i = 1; i < pos-1 ; i++)
                temp=temp.next;
            Node temp2 = temp.next;
            temp.next = temp2.next;
            temp2.next = null;
            size--;
        }
    }

    public static void main(String[] args) {
        LL_Circular_Singly_Linked_List list = new LL_Circular_Singly_Linked_List();
        Scanner scanner = new Scanner(System.in);
        int choice, value, position;

        System.out.println("\nSingly Linked List Menu:");
        System.out.println("1. Insert at Beginning");
        System.out.println("2. Insert at End");
        System.out.println("3. Insert at Position");
        System.out.println("4. Delete from Beginning");
        System.out.println("5. Delete from End");
        System.out.println("6. Delete from Position");
        System.out.println("7. Display List");
        System.out.println("8. Exit");

        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    value = scanner.nextInt();
                    list.insertBegin(value);
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    value = scanner.nextInt();
                    list.insertEnd(value);
                    break;
                case 3:
                    System.out.print("Enter value to insert and position: ");
                    value = scanner.nextInt();
                    position = scanner.nextInt();
                    list.insertPos(value, position);
                    break;
                case 4:
                    list.deleteBegin();
                    break;
                case 5:
                    list.deleteEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    position = scanner.nextInt();
                    list.deletePos(position);
                    break;
                case 7:
                    list.Display();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }


}
