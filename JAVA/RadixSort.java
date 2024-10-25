import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr) {
        // Find the maximum number to know the number of digits
        int max = Arrays.stream(arr).max().getAsInt();

        // Apply counting sort to sort elements based on the current digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array that will hold the sorted numbers
        int[] count = new int[10]; // Count array for digits (0 to 9)

        // Store the count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Print count array for debugging
        System.out.println("\nCount array for " + exp + " : " + Arrays.toString(count));

        // Change count[i] so that count[i] now contains the actual
        // position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Print updated count array for debugging
        System.out.println("Updated count array: " + Arrays.toString(count));

        // Build the output array
        for (int i = n - 1; i >= 0; i--) { // Corrected loop to go from n-1 to 0
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the sorted output array back to arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {23, 456, 7896, 44, 3, 46};
        System.out.println("Original array: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
