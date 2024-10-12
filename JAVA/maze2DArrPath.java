import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class maze2DArrPath {
//this code take row and column  it can see how many path it can go from start(0,0)toend(r,c)aand what r the path when it onlu rigth(vertical) or down(horizontal) or diagonall
    public static void main(String[] args) {
        int r,c;
        Scanner s = new Scanner(System.in);
        System.out.print("enter ROWS: ");
        r = s.nextInt();
        System.out.print("enter COLUMNS: ");
        c = s.nextInt();
        System.out.println(count_way(r,c));
        System.out.println(pathway("",r,c));
        boolean[][] map = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        //rest_pathway("",map,0,0);
        int[][]path = new int[map.length][map[0].length];
        All_pathway("",map,0,0);
        All_pathway_Print("",map,0,0,path,1);
    }

private static int count_way(int R, int C) {
        if (R == 1 || C == 1) {
            return 1;
        }
        int left = count_way(R-1,C);
        int right = count_way(R, C-1);
        return left+right;
    }

    private static ArrayList<String> pathway(String P ,int R, int C) {
        if (R == 1 && C == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(P);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (R > 1 && C>1)  list.addAll(pathway(P+'D',R-1,C-1));//diagonally
        if (R > 1)  list.addAll(pathway(P+'V',R-1,C)); //vertically
        if (C > 1)  list.addAll(pathway(P+'H',R,C-1));//horizonital
        return list;
    }

    private static  void rest_pathway(String P ,boolean[][] maze,int R, int C) {
        if (R == maze.length - 1 && C == maze[0].length - 1) {
            System.out.println(P);
            return;
        }
        if (!maze[R][C]) {
            return;
        }
        if (R < maze.length - 1) {
            rest_pathway(P+'D',maze,R+1,C);
        }
        if (C < maze[0].length - 1) {
            rest_pathway(P+'R',maze,R,C+1);
        }

    }

    private static  void All_pathway(String P ,boolean[][] maze,int R, int C) {
        if (R == maze.length - 1 && C == maze[0].length - 1) {
            System.out.println(P);
            return;
        }
        if (!maze[R][C])  return;
        maze[R][C] = false;
        if (R < maze.length - 1)  All_pathway(P+'D',maze,R+1,C);
        if (C < maze[0].length - 1)  All_pathway(P+'R',maze,R,C+1);
        if (R > 0)  All_pathway(P+'U',maze,R-1,C);
        if (C > 0)  All_pathway(P+'L',maze,R,C-1);
        maze[R][C] = true;

    }
    private static  void All_pathway_Print(String P ,boolean[][] maze,int R, int C,int[][] way,int side) {
        if (R == maze.length - 1 && C == maze[0].length - 1) {
            way[R][C] = side;
            for (int[] arr :way) System.out.println(Arrays.toString(arr));
            System.out.println(P);
            return;
        }
        if (!maze[R][C])  return;
        maze[R][C] = false;
        way[R][C] = side;
        if (R < maze.length - 1)  All_pathway_Print(P+'D',maze,R+1,C,way,side+1);
        if (C < maze[0].length - 1)  All_pathway_Print(P+'R',maze,R,C+1,way,side+1);
        if (R > 0)  All_pathway_Print(P+'U',maze,R-1,C,way,side+1);
        if (C > 0)  All_pathway_Print(P+'L',maze,R,C-1,way,side+1);
        maze[R][C] = true;
        way[R][C] = side;

    }
}

