import java.util.Scanner;
public class transposeofarray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        System.out.println("enter 9 digit:");

        for (int i = 0; i < matrix.length ; i++)
        {
            for (int j = 0; j < matrix.length ; j++)
            {
                matrix[i][j] = scan.nextInt();
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < matrix.length ; i++)
        {
            for (int j = i; j < matrix.length ; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        System.out.println("transpose");
        for (int i = 0; i < matrix.length ; i++)
        {
            for (int j = 0; j < matrix.length ; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("90 degree");
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 2; j >= 0; j--) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        


    }
}

