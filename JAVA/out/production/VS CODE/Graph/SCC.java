import java.util.ArrayList;
import java.util.Stack;

public class SCC // Strongly Connected Component
{
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

    private static void DFS(ArrayList<Edge>[] Graph, Boolean[] vis, int current) {
        System.out.print(current + " ");
        vis[current] = true;
        for (int i = 0; i < Graph[current].size(); i++) {
            Edge e = Graph[current].get(i);
            if (!vis[e.des]) {
                DFS(Graph, vis, e.des);
            }
        }
    }

    private static void toggleSortII(ArrayList<Edge>[] Graph, Boolean[] vis, int current, Stack<Integer> stack) {
        vis[current] = true;
        for (int i = 0; i < Graph[current].size(); i++) {
            Edge e = Graph[current].get(i);
            if (!vis[e.des]) {
                toggleSortII(Graph, vis, e.des, stack);
            }
        }
        stack.push(current); // Push to stack only after all adjacent nodes are visited
    }

    // Kosaraju's Algorithm
    public static void KosarajuAlgo(ArrayList<Edge>[] Graph, int V) {
        // Step 1
        Stack<Integer> stack = new Stack<>();
        Boolean[] vis = new Boolean[V];
        
        // Initialize all elements of vis to false
        for (int i = 0; i < V; i++) {
            vis[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                toggleSortII(Graph, vis, i, stack);
            }
        }

        // Step 2: Transpose the graph
        ArrayList<Edge>[] Transpose = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            Transpose[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < V; i++) {
            for (Edge e : Graph[i]) {
                Transpose[e.des].add(new Edge(e.des, e.src));
            }
        }

        // Step 3: DFS on the transposed graph in the order defined by the stack
        for (int i = 0; i < V; i++) {
            vis[i] = false;
        }
        
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!vis[current]) {
                DFS(Transpose, vis, current);
                System.out.println(); // New line for each SCC
            }
        }
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        ArrayList<Edge>[] Graph = new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            Graph[i] = new ArrayList<Edge>();
        }

        // Add edges
        Graph[0].add(new Edge(0, 2));
        Graph[1].add(new Edge(1, 0));
        Graph[2].add(new Edge(2, 1));
        Graph[0].add(new Edge(0, 3));
        Graph[3].add(new Edge(3, 4));

        // Find SCCs
        System.out.println("Strongly Connected Components:");
        KosarajuAlgo(Graph, V);
    }
}
