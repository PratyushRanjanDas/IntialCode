import java.util.Arrays;

public class RC_quickSort {
    public static void main(String[] args) {
        int[] ar = {5,4,3,2,1};
        RCQsort(ar,0, ar.length-1);
        System.out.println(Arrays.toString(ar));
    }

    private static void RCQsort(int[] arr, int low ,int high) {
        int s=low;
        int e=high;
        int mid=s+(e-s)/2;
        int pivot = arr[mid];
        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        RCQsort(arr,low,e);
        RCQsort(arr,s,high);
    }
}
