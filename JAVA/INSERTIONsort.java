import java.util.Arrays;

public class INSERTIONsort
{
    public static void Insertionsort (int[] arr)
    {
        for (int i = 0; i < arr.length-1 ; i++)
        {
            for (int j = i+1; j > 0 ; j--)
            {
                if (arr[j] < arr[j-1])
                {
                    arr[j]= arr[j]^arr[j-1];
                    arr[j-1]= arr[j]^arr[j-1];
                    arr[j]= arr[j]^arr[j-1];
                }
                else
                    break;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {19,45,2,3,100};
        Insertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
