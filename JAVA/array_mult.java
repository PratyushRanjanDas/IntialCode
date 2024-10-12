import java.util.Scanner;
public class array_mult
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("how many number you want to put :");
        int n = scn.nextInt();

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] mult = new int[n];
        System.out.println("enter the element of arr 1 & arr 2");
        for (int i = 0; i <n ; i++)
        {
            arr1[i] = scn.nextInt();
            System.out.println("arr1's input element :" + arr1[i]);
            arr2[i] = scn.nextInt();
            System.out.println("arr2's input element :" + arr2[i]);
            mult[i] = arr1[i] * arr2[i];
            System.out.println("mult of arr1 and arr2 :" + mult[i]);


        }


    }

}