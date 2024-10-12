
import java.util.Scanner;

public class nthmagicbinary {

    public static void main(String[] args)
    {
        int N;
        Scanner scn = new Scanner(System.in);
        System.out.println("enter Decimal :");
        N = scn.nextInt();
        int ans=0;
        int base=5;
        while (N>0)
        {
            int last = N & 1;
            N=N>>1;
            ans+=last*base;
            base=base*5;
        }
        System.out.println(ans);


    }
}
