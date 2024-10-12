import java.util.Arrays;

public class matrix_BS_rowcol
{

    public static void main(String[] args) {
    int[][] matrix =
            {
                    {1, 2, 4, 67},
                    {3, 5, 7, 75},
                    {6, 8, 9, 100},
                    {10, 11, 12, 120},
            };
    System.out.println(Arrays.toString(RCsearch(matrix, 1)));
}

    public static int[] RCsearch(int matrix[][], int target)
    {
        int r = 0, c = matrix.length - 1;
        while (r < matrix.length && c>=0) {
            if (matrix[r][c] == target)
            {
                return new int[]{r, c};
            }
            else if (matrix[r][c] < target)
            {
                r++;
            }
            else
            {
                c--;
            }
        }
        return new int[]{-1, -1};
    }
}