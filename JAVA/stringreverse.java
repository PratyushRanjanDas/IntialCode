import java.util.Scanner;
public class stringreverse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("input the string;");
        char[] letter = scn.nextLine().toCharArray();
        System.out.println("reversestring");
        for (int i = letter.length - 1; i >= 0 ; i--)
        {
           System.out.print(letter[i]);
       }
   }
}
