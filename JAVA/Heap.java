import java.util.ArrayList;
import java.util.Scanner;

public class Heap {
    private ArrayList<Integer> arr;

    public Heap() {
        arr = new ArrayList<>();
    }

    public void swap(int x, int y) {
        int temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

    public void insert() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter element:");
        int value = scan.nextInt();
        arr.add(value); // Add the new value to the end of the array
        upheap(arr.size() - 1); // Restore heap property
    }

    private void upheap(int i) {
        while (i > 0 && arr.get(i) < arr.get((i - 1) / 2)) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2; // Move up the tree
        }
    }

    public int delete() throws Exception {
        if (arr.isEmpty()) {
            throw new Exception("Array is empty;(");
        }
        int root = arr.get(0); // Get the root
        arr.set(0, arr.get(arr.size() - 1)); // Move the last element to the root
        arr.remove(arr.size() - 1); // Remove the last element
        downheap(0); // Restore heap property
        return root; // Return the removed root
    }

    private void downheap(int i) {
        int min = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < arr.size() && arr.get(left) < arr.get(min)) {
            min = left;
        }
        if (right < arr.size() && arr.get(right) < arr.get(min)) {
            min = right;
        }
        if (min != i) {
            swap(min, i);
            downheap(min);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Insert 2. Delete 3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    heap.insert();
                    break;
                case 2:
                    try {
                        int deletedValue = heap.delete();
                        System.out.println("Deleted: " + deletedValue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

