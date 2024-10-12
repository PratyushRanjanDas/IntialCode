import java.util.Scanner;
public class int_odd_even
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter how many number you want to put :");
        int n = scn.nextInt();
        int[] Aroe = new int[n];
        System.out.println("enter the element : ");
        for (int i = 0; i < n ; i++)
        {
            Aroe[i] = scn.nextInt();
            if (Aroe[i]%2 == 0) {
                System.out.println(Aroe[i] + " is even");
            }
            else{
                System.out.println(Aroe[i] + " is odd");
            }
        }


    }
}
