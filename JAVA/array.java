import java.util.Arrays;
import java.util.Scanner;
public class array
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("enter the element");
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("element are");
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println(" ");
        System.out.println(Arrays.toString(arr));
    }
}
