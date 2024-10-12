import java.util.*;
public class powbit
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the no");
        int a = s.nextInt();
        System.out.println("enter the power ");
        int b = s.nextInt();
        int n = 1;
        while(b>0)
        {
            if ((b&1) == 1)
            {
                n*=a;
            }
            a*=a;
            b=b>>1;
        }
        System.out.println(n);

    }
}
