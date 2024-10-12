import java.util.Scanner;

public class sner {
    public static void main(String[] args)
    {
        int A,B,SUM;
        try (Scanner SN = new Scanner(System.in)) {
            {
                System.out.println("enter first no:");
                A=SN.nextInt();
                System.out.println("enter second no:");
                B=SN.nextInt();
            }
        }
        SUM=A+B;
        System.out.println("THE ADDITION:"+SUM);

    }
}

