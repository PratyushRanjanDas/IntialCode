import java.lang.reflect.Array;
import java.util.Arrays;

public class RC_mergeSort {
    public static void main(String[] args) {
        int[] arr = {80,26,44,32};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mergeSort(int[] arr)
    {
        if (arr.length==1) return  arr;
        int mid=arr.length/2;
        int[] first = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] second = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return Msort(first,second);
    }

    private static int[] Msort(int[] first, int[] second) {
        int[] third = new int[first.length+ second.length];
        int i=0,j=0,k=0;
        while(i<first.length && j< second.length)
        {
            if(first[i]<second[j])
            {
                third[k]=first[i];
                i++;
            }
            else
            {
                third[k]=second[j];
                j++;
            }
            k++;
        }
        while(i<first.length)
        {
            third[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length)
        {
            third[k]=second[j];
            j++;
            k++;
        }

        return third;
    }
}
