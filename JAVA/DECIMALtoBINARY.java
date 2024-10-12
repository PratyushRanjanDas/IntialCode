import java.util.Scanner;
public class DECIMALtoBINARY
{
    public static int[] DTB(int N)
    {
        int[] arr = new int[100000000];
        int i = 0 ;
        int count=0;

        while (N > 0)
        {
            arr[i] = N % 2 ;
            N = N / 2 ;
            i++;
            count++;
        }
        System.out.println(count);



        System.out.println("binary" );
        bioe(arr,i);

        return arr;
    }
    public static void bioe(int[] arr,int i){
        for(int j = i-1 ; j>=0 ; j-- )
        {
            System.out.print(arr[j]);
        }
        System.out.println();
        if (arr[0]==1) {
            System.out.println("odd");
        }
        else
        {
            System.out.println("even");
        }
    }

    public static void main(String[] args)
    {
        int N;
        Scanner scn = new Scanner(System.in);
        System.out.println("enter Decimal :");
        N = scn.nextInt();
        DTB(N);

    }

}
