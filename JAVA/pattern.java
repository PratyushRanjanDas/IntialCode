import java.util.Scanner;
public class pattern {

    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
        System.out.println("Eneter the no of rows : ");
        int Row = scn.nextInt();

        for (int i = 1; i <= Row ; i++) {
            for (int j = Row; j > i ; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(i);
            }
            System.out.println();
        }

    }
}