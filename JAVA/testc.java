public class testc {


        public static void main(String [] args)
        {
            int marks[][]=new  int[3][3];
            marks[0][0] = 2;
            marks[0][1] = 3;
            marks[0][2] = 4;
            marks[1][0] = 5;
            marks[1][1] = 2;
            marks[1][2] = 2;
            marks[2][0] = 6;
            marks[2][1] = 7;
            marks[2][2] = 8;
            for(int i=0;i< marks.length;i++){
                for(int j=0;j< marks[i].length;j++){
                    System.out.print(marks[i][j]+" ");
                }
                System.out.println( );
            }
        }

}
