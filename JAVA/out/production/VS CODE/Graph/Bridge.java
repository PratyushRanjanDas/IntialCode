import java.util.ArrayList;

public class Bridge {
    
    public static class Edge {
        int src;
        int des;
        int wei;
        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.wei = weight;
        }
        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void GetBridge(ArrayList<Edge>[] Graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(Graph, vis, dt, low, time, i, -1);
            }
        }
    }

    private static void dfs(ArrayList<Edge>[] Graph, boolean[] vis, int[] dt, int[] low, int time, int cur, int par) {
        vis[cur] = true;
        dt[cur] = low[cur] = ++time;
        
        for (int i = 0; i < Graph[cur].size(); i++) {
            Edge e = Graph[cur].get(i);
            if (e.des == par) {
                continue;
            } else if (!vis[e.des]) {
                dfs(Graph, vis, dt, low, time, e.des, cur);
                low[cur] = Math.min(low[cur], low[e.des]);
                
                if (dt[cur] < low[e.des]) {
                    System.out.println("Bridge = " + cur + " -- " + e.des);
                }
            } else {
                low[cur] = Math.min(low[cur], dt[e.des]);
            }
        }
    }

    public static void createGraphUndirected(ArrayList<Edge>[] Graph, int[][] edges) {
        for (int[] edge : edges) {
            int src = edge[0];
            int des = edge[1];
            
            Graph[src].add(new Edge(src, des));
            Graph[des].add(new Edge(des, src));
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<Edge>[] Graph = new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            Graph[i] = new ArrayList<>();
        }

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {1, 3},
            {3, 4}
        };

        createGraphUndirected(Graph, edges);

        GetBridge(Graph, V);
    }
}
