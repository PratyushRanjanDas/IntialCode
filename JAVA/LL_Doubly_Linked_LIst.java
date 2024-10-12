import java.util.Scanner;

public class LL_Doubly_Linked_LIst {
    private Node head;
    private Node tail;
    private int size;

    public LL_Doubly_Linked_LIst(){
        this.size=0;
    }
    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value)
        {
            this.value=value;
        }

        public Node(int value,Node next,Node prev)
        {
            this.value=value;
            this.next=next;
            this.prev=prev;
        }
    }

    void insertBegin(int value){
        Node node = new Node(value);
        //at very beginning when there is no ele
        if (head == null)
        {
            head=node;
            tail=node;
        }
        //node.next p.N.n->previous head making it 2nd ele and head change
        else
        {
            node.next=head;
            head=node;
        }
        size++;
    }

    void insertEnd(int value)
    {
        Node node = new Node(value);
        //if there is no node in list
        if (head == null)
            insertBegin(value);
        //it adds the node in the end with the help of tail
        else
        {
            tail.next=node;
            node.prev=tail;
            tail=node;
            size++;
        }
    }

    void insertPos(int value, int pos)
    {
        if (pos < 1 || pos>size+1)
            System.out.println("Invalid Position");
        else if (pos == 1)
            insertBegin(value);
        else if (pos == size)
            insertEnd(value);
        else
        {
            //creating a node which hold the value & temp(it will bw before node one) to adjust the node
            Node node = new Node(value);
            Node temp = head;
            for (int i = 1; i < pos-1 ; i++)
                temp = temp.next;
            node.prev = temp;
            node.next =  temp.next;
            temp.next.prev = node;
            temp.next = node;
            size++;
        }
    }

    void Display(){
        Node temp = head;
        int x = size;
        System.out.println("Size: " + x);
        System.out.print("[");
        //using while loop for printing the value
        while (temp != null){
            System.out.print(" " + temp.value);
            temp=temp.next;
        }
        System.out.println(" ]");
    }
    
    void deleteBegin()
    {
        //to check if there are any element
        if (head == null) {
            System.out.println(" there is no node in List");
            return;
        }
        //if there is one node
        if (head == tail) {
            head = null;
            tail = null;
        }
        //if their already too many node
        else
        {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
        size--;
    }

    void  deleteEnd()
    {
        //if there is no node
        if (head == null) {
            System.out.println(" there is no node in List");
            return;
        }
        //if there is one node
        if (head == tail) {
            head = null;
            tail = null;
        }
        //if there is more than one node
        else
        {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
        size--;
    }

    void deletePos(int pos)
    {
        if (head == null) {
            System.out.println("linked list underflow");
            return;
        }
        //if the position is invalid
        if(pos<1 || pos>size)
            System.out.println("invalid position");
        // if the pos is at begin
        else if (pos == 1)
            deleteBegin();
        // if the pos is at end
        else if (pos == size)
            deleteEnd();
        // if thw pos in between
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


    public static void main(String[] args) {
        LL_Doubly_Linked_LIst list = new LL_Doubly_Linked_LIst();
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
