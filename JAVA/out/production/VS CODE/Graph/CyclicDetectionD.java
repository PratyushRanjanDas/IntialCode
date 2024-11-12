import java.util.ArrayList;

public class CyclicDetectionD {

    static class Edge {
        int src;
        int des;
        int wei;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }

        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.wei = weight;
        }
    }

    public static boolean CDdirected(ArrayList<Edge>[] Graph, boolean[] vis, int cur, boolean[] rec) {
        vis[cur] = true;
        rec[cur] = true;

        for (int i = 0; i < Graph[cur].size(); i++) {
            Edge e = Graph[cur].get(i);

            if (rec[e.des]) {  // Cycle detected in directed graph
                return true;
            } else if (!vis[e.des]) {
                if (CDdirected(Graph, vis, e.des, rec)) {
                    return true;
                }
            }
        }
        rec[cur] = false;
        return false;
    }

    public static boolean CDUndirected(ArrayList<Edge>[] Graph, boolean[] vis, int cur, int par) {
        vis[cur] = true;
    
        for (int i = 0; i < Graph[cur].size(); i++) {
            Edge e = Graph[cur].get(i);
    
            if (vis[e.des] && par != e.des) {
                return true; // Cycle detected
            }
            
            if (!vis[e.des]) {
                if (CDUndirected(Graph, vis, e.des, cur)) {
                    return true; // Propagate cycle detection result
                }
            }
        }
        return false; // No cycle detected in this path
    }
    
    public static void createGraph(ArrayList<Edge>[] Graph) {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<Edge>();
        }
        Graph[0].add(new Edge(0, 1));
        Graph[1].add(new Edge(1, 0));
        Graph[1].add(new Edge(1, 2));
        Graph[1].add(new Edge(1, 3));
        Graph[2].add(new Edge(2, 3));
        Graph[2].add(new Edge(2, 1));
        Graph[3].add(new Edge(3, 1));
        Graph[3].add(new Edge(3, 2));



        
        // Directed edges only, no backtracking
        // Graph[0].add(new Edge(0, 1));
        // Graph[0].add(new Edge(0, 2));
        // Graph[1].add(new Edge(1, 3));
        // Graph[2].add(new Edge(2, 4));
        // Graph[3].add(new Edge(3, 5));
        // Graph[4].add(new Edge(4, 5));
        // Graph[5].add(new Edge(5, 6));
        // Graph[6].add(new Edge(6, 0)); // This edge creates a cycle

        /*Graph[0].add(new Edge(0, 1));
        Graph[2].add(new Edge(2, 1));
        Graph[2].add(new Edge(2, 3));
        Graph[3].add(new Edge(3, 4));
        Graph[4].add(new Edge(4, 2));*/
        // Remove any reverse edges to ensure it's unidirectional
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] Graph = new ArrayList[V];
        createGraph(Graph);

        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];
        boolean hasCycle = false;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (CDUndirected(Graph, vis, i, i)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        if (hasCycle) {
            System.out.println("Cycle detected in directed graph.");
        } else {
            System.out.println("No cycle detected in directed graph.");
        }
    }
}
