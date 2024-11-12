import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjacencyGraph{
    static class Edge {
        int src;
        int des;
        int wei;
        public Edge(int src,int des)
        {
            this.src = src;
            this.des = des;
        }
        public Edge(int src,int des,int weigth)
        {
            this.src = src;
            this.des = des;
            this.wei = weigth;
        }
    }

    public static void createGraph(ArrayList <Edge> Graph[])
    {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList <Edge> ();
        }
        Graph[0].add(new Edge(0,1));
        Graph[0].add(new Edge(0,2));
        Graph[1].add(new Edge(1,3));
        Graph[1].add(new Edge(1,0));
        Graph[2].add(new Edge(2,0));
        Graph[2].add(new Edge(2,4));
        Graph[3].add(new Edge(3,1));
        Graph[3].add(new Edge(3,4));
        Graph[3].add(new Edge(3,5));
        Graph[4].add(new Edge(4,3));
        Graph[4].add(new Edge(4,5));
        Graph[4].add(new Edge(4,2));
        Graph[5].add(new Edge(5,4));
        Graph[5].add(new Edge(5,3));
        Graph[5].add(new Edge(5,6));
        Graph[6].add(new Edge(6,5));
    }

    public static void createGraphW(ArrayList <Edge> Graph[])
    {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList <Edge> ();
        }
        Graph[0].add(new Edge(0,1,5));
        Graph[1].add(new Edge(1,0,5));
        Graph[1].add(new Edge(1,2,4));
        Graph[2].add(new Edge(2,1,4));
        Graph[2].add(new Edge(2,4,6));
        Graph[2].add(new Edge(2,3,2));
        Graph[3].add(new Edge(3,2,2));
        Graph[3].add(new Edge(3,4,8));
        Graph[4].add(new Edge(4,2,6));
        Graph[4].add(new Edge(4,3,8));
    }

    //~BFS code traseverse the the code while keep its ele in a queue and true every visited node O(v+e)
    public static void BFS (ArrayList <Edge> Graph[],int v,boolean   vis [] , int start )//the reson start is given due to discountinue graph
        {
            Queue<Integer> q = new LinkedList<>();//creating a queue using predeine class with an arraylist
            q.add(start);//inset queue ele
    
            while(!q.isEmpty())
            {
                int current = q.remove();//remove return int as the ele deleted 
                if (vis[current] == false) {
                    System.out.print(current +" ");
                    vis[current] = true;
                }
                for (int i = 0; i < Graph[current].size(); i++) {
                    Edge e = Graph[current].get(i);
                    q.add(e.des);
                }
            }
        }

    public static void DFS (ArrayList <Edge> Graph[],boolean   vis [] , int  start )//O(v+e)
    {
        
        System.out.print(start + " ");
        vis[start] = true;
        for (int i = 0; i < Graph[start].size(); i++) {
            Edge e = Graph[start].get(i);
            if (vis[e.des] == false) {
                DFS(Graph,vis,e.des);
            }
            
        }
    }

    public static void allPath (ArrayList <Edge> Graph[],boolean   vis [] , int  start , int target , String path )//O(v+e)
    {
        //O(v^v)
        if(start == target)
        {
            System.out.println(path);
            return;
        }
        
        
        for (int i = 0; i < Graph[start].size(); i++) {
            Edge e = Graph[start].get(i);
            if (! vis[e.des]) {
                vis[start] = true;
                allPath(Graph, vis, e.des, target, path+e.des+"->");
                vis[start] = false;
            }
        }
        
    }
    
    public static void main(String[] args) {
        int v = 7;
        Scanner scan = new Scanner(System.in);
        System.out.print("which index neigbhour u want ");
        int n = scan.nextInt();
        ArrayList <Edge> Graph[] = new ArrayList[v];
        createGraph(Graph);
        /*  for (int i = 0; i < Graph[n].size(); i++) {
            Edge e = Graph[n].get(i);
            System.out.println("the weigth of source "+e.src+" & destination "+e.des+" is "+e.wei + " ");
        }*/

    boolean vis[] = new boolean[v];
    for(int y = 0 ; y < v ; y++)
    {
        
        BFS(Graph,v,vis,y);
        
}
    DFS(Graph,vis,0);
    }
}