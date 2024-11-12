import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {
    
    public static class Edge {
        int src;
        int des;
        int wei;
        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.wei = weight;
        }
    }

    public static class Pair implements Comparable<Pair>
{ 
        int node;
        int cost;
        public Pair(int n, int d) {
            this.node = n;
            this.cost = d;
        }
        @Override
        public int compareTo(Pair p2) 
        {
            return this.cost - p2.cost; // ascending order priority
        }
}


    public static void PrimsAlgo(ArrayList <Edge> Graph[],int V)
    {
    PriorityQueue<Pair> pq = new PriorityQueue<>(); 
    boolean[] vis = new boolean[V];
    pq.add(new Pair(0, 0));

    int mstCost = 0;

    while (!pq.isEmpty()) {
        Pair cur = pq.remove();
        if (!vis[cur.node]) {
            vis[cur.node] = true;
            mstCost += cur.cost;

            for (int i = 0; i < Graph[cur.node].size(); i++) {
                Edge e = Graph[cur.node].get(i);
                if (!vis[e.des]) {
                    pq.add(new Pair(e.des, e.wei));
                }
            }
        }
    }
    System.out.println("Total cost of MST: " + mstCost);
}

public static void createGraph(ArrayList<Edge> Graph[]) {
    for (int i = 0; i < Graph.length; i++) {
        Graph[i] = new ArrayList<Edge>();
    }

    // Adding edges to the graph
    Graph[0].add(new Edge(0, 1, 4)); // Edge from 0 to 1 with weight 4
    Graph[0].add(new Edge(0, 2, 3)); // Edge from 0 to 2 with weight 3
    Graph[1].add(new Edge(1, 2, 1)); // Edge from 1 to 2 with weight 1
    Graph[1].add(new Edge(1, 3, 2)); // Edge from 1 to 3 with weight 2
    Graph[2].add(new Edge(2, 3, 4)); // Edge from 2 to 3 with weight 4
    Graph[2].add(new Edge(2, 4, 5)); // Edge from 2 to 4 with weight 5
    Graph[3].add(new Edge(3, 4, 7)); // Edge from 3 to 4 with weight 7
}

public static void main(String[] args) {
    int V = 5; // Number of vertices
    ArrayList<Edge>[] Graph = new ArrayList[V];
    
    createGraph(Graph); // Create the graph with weights
    
    PrimsAlgo(Graph, V); // Run Prim's algorithm
}

}
