import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CounttSort {

    public static void COUNTsort(int arr[])
    {
        if (arr == null)
        {
            return;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int[] count = new int[max+1];
        for (int num:arr) {
               count[num]++;
        }
        System.out.println(Arrays.toString(count));
        int index = 0;
        for(int i=0; i<= max; i++) {
            while(count[i] > 0) {
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void countSortHash(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for(int i=min; i<=max; i++) {
            int count = countMap.getOrDefault(i, 0);
            for(int j=0; j < count; j++) {
                arr[index] = i;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

        public static void main(String[] args) {
        int [] arr = {5,2,1,2,3,2};
        COUNTsort(arr);
        countSortHash(arr);
    }

    

}

