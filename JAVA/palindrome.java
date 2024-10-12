import java.util.Scanner;

public class palindrome {

    public  static void isPalindrome(int X) {
        int temp = X;
        int pal = 0,r;
        while(X > 0)
        {
            r = X%10;
            pal = (pal*10) + r;
            X=X/10;
        }
          if (temp==pal)
              System.out.println("PALINDROME");
          else
              System.out.println("NOT PALINNDROME");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter input");
        int a = sc.nextInt();
        isPalindrome(a);

    }


}
