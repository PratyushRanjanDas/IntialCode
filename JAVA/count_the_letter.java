import java.util.Scanner;
public class count_the_letter
{
    public static void CTL(String count)
    {
        int letter = 0 ;
        int digit = 0 ;
        int space = 0 ;
        int special = 0 ;
        char[] CHR =count.toCharArray();

        for (int i = 0; i <count.length() ; i++)
        {
            if (Character.isLetter(CHR[i]))
            {

                letter++;

            }

            else if (Character.isDigit(CHR[i]))
            {

                digit++;

            }

            else if (Character.isSpaceChar(CHR[i]))
            {

                space++;

            }

            else
            {

                special++;

            }
        }
        System.out.println(" the total letter is "+ letter);
            System.out.println(" the total digit is "+ digit);
            System.out.println(" the total space is "+ space);
            System.out.println(" the total special is "+ special);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("put ur senetence :");
        String st =scn.next();
        CTL(st);
    }
}
