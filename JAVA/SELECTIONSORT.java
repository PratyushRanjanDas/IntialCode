import java.util.*;
public class SELECTIONSORT
{
    public static void main(String[] args)
    {
        int[] arr = {3,2,7,77,5};

        int n = arr.length;


        for (int i = 0; i < n-1; i++) {

            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;


                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            


        }

        for (int i = 0; i<5; i++)
        {
            System.out.println(arr[i]);
        }
    }
}
