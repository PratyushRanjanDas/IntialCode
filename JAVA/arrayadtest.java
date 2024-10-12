import java.util.Arrays;
import java.util.Scanner;

public class arrayadtest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        System.out.println("enter 9 digit:");

        for (int i = 0; i < matrix.length ; i++)
        {
            for (int j = 0; j < matrix.length ; j++)
            {
                matrix[i][j] = scan.nextInt();
            }
            System.out.println();
        }
       for (int[] arr : matrix)
       {
           System.out.println(arr);
       }
}
}

