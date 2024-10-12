public class Nqueen {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board,0));
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            dispaly(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }

        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        int maxLeft = Math.min(row,col);
        for (int i = 0; i <= maxLeft ; i++) {
            if(board[row-i][col-i]) return  false;
        }

        int maxRigth = Math.min(row, board.length - col - 1);
        for (int i = 0; i <= maxRigth ; i++) {
            if(board[row-i][col+i]) return  false;
        }
        return true;
    }


    private static void dispaly(boolean[][] boards){
        for (boolean[] rows : boards) {
            for (boolean ele : rows) {
                if (ele) System.out.print(" Q ");
                else System.out.print(" X ");
            }
            System.out.println();
        }

    }


}
