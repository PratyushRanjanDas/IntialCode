import java.util.*;
public class pandulum {
    public static void printPendulumArrangement(int[] arr) {
        int n = arr.length;

        // Sort the array
        Arrays.sort(arr);

        // Find the middle index
        int mid = n / 2;

        // Initialize left and right pointers
        int left = mid - 1;
        int right = mid + 1;

        // Print the array in pendulum arrangement
        for (int i = 0; i < n; i++) {
            if (i == mid) {
                System.out.print(arr[mid] + " ");
            } else if (i < mid) {
                System.out.print(arr[left] + " ");
                left--;
            } else {
                System.out.print(arr[right] + " ");
                right++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {11, 2, 4, 55, 6};
        printPendulumArrangement(arr);
    }
}
