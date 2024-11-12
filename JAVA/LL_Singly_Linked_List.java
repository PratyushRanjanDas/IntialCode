import java.util.Scanner;

public class LL_Singly_Linked_List {
    private Node head;
    private Node tail;
    private int size;
    public LL_Singly_Linked_List() {
        this.size=0;
    }
    private class  Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    void insertBegin(int value)
    {
     //node creation
        Node node = new Node(value);
     //if head is null
        if(head == null) 
        {
            head=node;
            tail=head;
        }
     //if there is already a head
        else
        {
            node.next=head;
            head=node;
        }
        size++;
    }

    void insertEnd(int value)
    {
     //node creation
        Node node = new Node(value);
    //if theis is the first node
        if (head == null) 
        {
            head=node;
            tail=head;
        }
    //it adds the node at end
        else
        {
            tail.next=node;
            tail=node;
        }
        size++;
        }

    void insertPos(int value, int pos)
    {
        if (pos < 1 || pos > size) 
        {
            System.out.println("invalid position");
            return;
        }
    //if the position is at begin
        else if (pos==0)
            insertBegin(value);
    //if the position is at end
        else if (pos==size)
            insertEnd(value);
        else
        {
    //traverse a node temp to the position so the node can direct to it
            Node temp = head;
            for (int i = 1; i < pos-1 ; i++)
                temp=temp.next;
            Node node = new Node(value);
            node.next = temp.next;
            temp.next=node;
            size++;
        }
    }

    void insertRec(int value , int pos )
    {
        if (pos <  0 || pos > size) 
        {
            System.out.println("invalid position");
            return;
        }
        Scanner scan = new Scanner(System.in);
        if(pos == 0)
        {
            Node node = new Node(value);
            node.next = head;
            head = node;
            size++;
            System.out.println("do u want to move to next node or stop here [if yes true if no false]:");
            System.out.print("Enter true or false: ");
            String input = scan.nextLine();
            boolean x = Boolean.parseBoolean(input);
            if (x) {
                System.out.println("enter new node :");
                int v = scan.nextInt();
                System.out.println("enter your position");
                int p = scan.nextInt();
                insertRec(v, p);
            }
            else return;
        }
        else if(pos == size)
        {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            size++;
            System.out.println("do u want to move to next node or stop here [if yes true if no false]:");
            System.out.print("Enter true or false: ");
            String input = scan.nextLine();
            boolean x = Boolean.parseBoolean(input);
            if (x) {
                System.out.println("enter new node :");
                int v = scan.nextInt();
                System.out.println("enter your position");
                int p = scan.nextInt();
                insertRec(v, p);
            }
            else return;
        }
        else
        {
            Node temp = head;
            for (int i = 1; i < pos-1 ; i++)
                temp=temp.next;
            Node node = new Node(value);
            node.next = temp.next;
            temp.next=node;
            size++;
            System.out.println("do u want to move to next node or stop here [if yes true if no false]:");
            System.out.print("Enter true or false: ");
            String input = scan.nextLine();
            boolean x = Boolean.parseBoolean(input);
            if (x) {
                System.out.println("enter new node :");
                int v = scan.nextInt();
                System.out.println("enter your position");
                int p = scan.nextInt();
                insertRec(v, p);
            }
            else return;
        }
    }

    void Display()
    {
        Node temp = head;
        System.out.print("[");
        int x = size;
    //while, so it can print the tail before loop break
        while (temp != null)
        {
            System.out.print(" " + temp.value);
            temp=temp.next;
        }
        System.out.println(" ]");
    }

    void deleteBegin()
    {
        if (head == null) 
        {
            System.out.println("linked list underflow");
            return;
        }
        System.out.println("Deleted Element " + head.value);
        Node temp = head;
        head = head.next;
        temp.next=null;
        if (head == null) 
        {
            tail = null;
        }
        size--;
        }

    void deleteEnd(){
        if (head == null) {
            System.out.println("linked list underflow");
            return;
        }
        //head == tail mean first ele
        if (size == 1) {
            deleteBegin();
            return;
        }
        else
        {
            System.out.println("Deleted Element " + tail.value);
            //this will take to the element before end
            Node temp = head;
            while (temp.next.next != null)
                temp=temp.next;
            temp.next=null;
            tail=temp;
            size--;
        }
    }

    void deletePos(int pos) {
        if (head == null) {
            System.out.println("linked list underflow");
            return;
        }
        if (pos < 0 || pos > size) {
            System.out.println("invalid position");
            return;
        }

        // Handle deleting the first node efficiently
        if (pos == 1) {
            deleteBegin();
            return;
        }

        // Handle deleting the last node efficiently
        if (pos == size) {
            deleteEnd();
            return;
        }

        // Delete node at an intermediate position
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }

        // Printing deleted element (optional)
        System.out.println("Deleted Element " + temp.next.value);

        // Update links to skip the deleted node
        Node temp2 = temp.next;
        temp.next = temp.next.next;
        temp2.next = null;

        size--;
    }

    void Reverse()
    {
        Node temp = null;
        Node temp2 = null;
        while (head != null)
        {
            temp2 = head.next;
            head.next = temp;
            temp = head;
            head = temp2;
        }
        head = temp;
    }

    public static void main(String[] args) {
        LL_Singly_Linked_List list = new LL_Singly_Linked_List();
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
        System.out.println("8. Reverse");
        System.out.println("9. RecInsert");
        System.out.println("10. Exit");

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
                    list.Reverse();
                    break;
                case 9:
                System.out.print("Enter value to insert and position: ");
                value = scanner.nextInt();
                position = scanner.nextInt();
                list.insertRec(value, position);
                break;
                case 10:
                    System.out.println("..........BYE BYE..................");
                    System.out.println(".............................^   ^ ");
                    System.out.println("........................... (>^_^<)");
                    System.out.println("............................. u u  ");
                    System.out.println("............................. u u  ");
                    System.out.println(".............................  s  ");
                    System.out.println("...................................");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 9);

        scanner.close();
    }

}
