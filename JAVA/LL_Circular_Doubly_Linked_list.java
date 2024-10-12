import java.util.Scanner;
public class LL_Circular_Doubly_Linked_list {
    private Node head;
    private Node tail;
    private int size;

    public LL_Circular_Doubly_Linked_list(){
        this.size = 0;
    }

    public class Node {
        private Node next;
        private Node prev;
        private int value;

        public Node (int value)
        {
            this.value = value;
        }
    }

    void  insertBegin(int value)
    {
        Node node = new Node(value);
        //when there's no node in linked list
        if (head == null)
        {
            head = node;
            tail = node;
            node.next = node;
            node.prev = node;
        }
        //when there's at least one node
        else
        {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            head = node;
        }
        size++;
    }

    void insertEnd(int value)
    {
        Node node = new Node(value);
        //if there's no node
        if (head == null) {
            insertBegin(value);
        }
        //if there's already some node
        else
        {
            tail.next = node;
            head.prev = node;
            node.prev = tail;
            node.next = head;
            tail = node;
            size++;
        }
    }

    void insertPos(int value , int pos)
    {
        //if the pos is below 1 or preceding the size
        if (pos < 1 || pos > size)
            System.out.println("Invalid Position");
        // if pos at beginning
        else if (pos == 1)
            insertBegin(value);
        // if pos at end
        else if (pos == size)
            insertEnd(value);
        // if the position at random middle
        else
        {
            Node node = new Node(value);
            Node temp = head;// for traverse
            for (int i = 1; i < pos-1; i++)
                temp = temp.next;
            node.prev = temp;
            node.next = temp.next;
            temp.next.prev = node;
            temp.next = node;
            size++;
        }
    }

    void deleteBegin()
    {
        //if there's no node
        if (head == null)
        {
            System.out.println("no node in list");
            return;
        }
        //if there's one node
        if (head == tail)
        {
            head.next = null;
            tail.prev = null;
            head = null;
            tail = null;
        }
        //if there are more than one node
        else
        {
            Node temp = head;
            head = head.next;
            head.prev = tail;
            tail.next = head;
            temp.prev = null;
            temp.next = null;
        }
        size--;
    }

    void deleteEnd() {
        //if there's no node
        if (head == null) {
            System.out.println("no node in list");
            return;
        }
        //if there's one node
        if (head == tail) {
            head.next = null;
            tail.prev = null;
            head = null;
            tail = null;
        }
        //if there are more than one node
        else
        {
            Node temp = tail;
            tail.prev.next =  head;
            head.prev = tail.prev;
            tail = tail.prev;
            temp.next = null;
            temp.prev = null;
        }
        size--;
    }

    void deletePos(int pos)
    {
        //if there's no node
        if (head == null) {
            System.out.println("no node in list");
            return;
        }
        //if the pos is below 1 or preceding the size
        if (pos < 1 || pos > size)
            System.out.println("Invalid Position");
            // if pos at beginning
        else if (pos == 1)
            deleteBegin();
            // if pos at end
        else if (pos == size)
            deleteEnd();
        // if the position at random middle
        else
        {

            Node temp = head;
            for (int i = 1; i < pos ; i++)
                temp = temp.next;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            temp.next = null;
            temp.prev = null;
            size--;
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
        //for the first node
        System.out.print(" " + temp.value);
        temp = temp.next;

        // Loop until we reach the head again (but print this time)
        while (temp != head){
            System.out.print(" " + temp.value);
            temp=temp.next;
        }
        System.out.println(" ]");
    }


    public static void main(String[] args) {
         LL_Circular_Doubly_Linked_list list = new LL_Circular_Doubly_Linked_list();
        Scanner scanner = new Scanner(System.in);
        int choice, value, position;

        do {
            System.out.println("\nCircular Doubly Linked List Menu:");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display List");
            System.out.println("8. Exit");
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
