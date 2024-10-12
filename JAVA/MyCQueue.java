import java.util.Scanner;

public class MyCQueue {
    private int[] queue;
    private int capacity;
    private int front;
    private int rear;

    MyCQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = -1; // Initially empty
        this.rear = -1;  // Initially empty
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    // Add an element to the queue
    void enqueue() {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter an element: ");
            int item = scan.nextInt();
            if (isEmpty()) {
                front = 0; // First element, set front to 0
            }
            rear = (rear + 1) % capacity;
            queue[rear] = item;
        }
    }

    // Remove an element from the queue
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue doesn't have any elements");
        } else {
            int dequeuedElement = queue[front];
            System.out.println("Deleted element is: " + dequeuedElement);
            if (front == rear) {
                // Queue becomes empty after this dequeue
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
        }
    }

    // Display the elements in the queue
    void display() {
        if (isEmpty()) {
            System.out.println("Queue doesn't have any elements");
        } else {
            System.out.print("The Queue's Elements: [ ");
            int i = front;
            while (true) {
                System.out.print("'" + queue[i] + "' ");
                if (i == rear) break;
                i = (i + 1) % capacity;
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of Queue: ");
        int s = scan.nextInt();
        MyCQueue queue = new MyCQueue(s);
        System.out.println("\nMenu:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Display");
        System.out.println("4. Exit");
        int choice;
        do {
            System.out.print("Choose an option: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    queue.enqueue();
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 4);

        scan.close();
    }
}
