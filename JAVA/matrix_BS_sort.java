import java.util.*;


public class matrix_BS_sort {
    public static int[] matrixSBS ( int matrix[][], int target)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0 ;
        int end = row*col-1;
        int mid = start +(end-start)/2;
        while(start <= end)
        {

            int ans = matrix[mid/col][mid%col];
            if(ans == target )
            {
                return new int[]{(mid/col),(mid%col)};
            }
            if (ans < target)
            {
                start = mid+1;
            }
            else
            {
                end = mid - 1;
            }
            mid = start+ (end - start )/2;
        }
        return new int[]{-1,-1} ;

    }
    public static void main(String[] args) {

        {
          int[][] matrix ={
                  {1,2,3},
                  {4,5,6},
                  {7,8,9},
          };

            System.out.println(matrixSBS(matrix,6));
        }
    }
}