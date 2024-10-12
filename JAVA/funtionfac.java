
import java.util.Scanner;

public class funtionfac 
{
    public static int factor(int N) 
    {
        int fac=1;
        int i;
        for(i=2; i <= N ; i++)
        fac *= i;
        return fac;
    }
    public static void main(String[] args) {
        int N;
        Scanner scn = new Scanner(System.in);
        System.out.println("write the no");
        N = scn.nextInt();
        System.out.println(factor(N));

    }
}
