import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class DijkstraAlgoShortestPath {
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

    public static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist; // ascending order priority
        }
    }

    public static void longestPath(ArrayList<Edge>[] graph, int src, int v) {
    int[] dist = new int[v];
    boolean[] vis = new boolean[v];

    // Initialize distances to all nodes as negative infinity except for the source node
    for (int i = 0; i < v; i++) {
        dist[i] = (i == src) ? 0 : Integer.MIN_VALUE;
    }

    // Perform topological sort
    Stack<Integer> topoStack = new Stack<>();
    for (int i = 0; i < v; i++) {
        if (!vis[i]) {
            topologicalSort(graph, i, vis, topoStack);
        }
    }

    // Process nodes in topological order
    while (!topoStack.isEmpty()) {
        int u = topoStack.pop();
        
        // Relaxation step for all adjacent nodes
        if (dist[u] != Integer.MIN_VALUE) {
            for (Edge edge : graph[u]) {
                int vNode = edge.des;
                int weight = edge.wei;

                // Update the distance if a longer path is found
                if (dist[u] + weight > dist[vNode]) {
                    dist[vNode] = dist[u] + weight;
                }
            }
        }
    }

    // Print the longest distances
    System.out.println("Longest distances from source " + src + ":");
    for (int i = 0; i < v; i++) {
        if (dist[i] == Integer.MIN_VALUE) {
            System.out.println("Node " + i + ": Unreachable");
        } else {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }
}

// Helper method for topological sort
private static void topologicalSort(ArrayList<Edge>[] graph, int node, boolean[] vis, Stack<Integer> stack) {
    vis[node] = true;

    for (Edge edge : graph[node]) {
        if (!vis[edge.des]) {
            topologicalSort(graph, edge.des, vis, stack);
        }
    }

    stack.push(node);
}




    public static void dijkstra(ArrayList<Edge> graph[], int src, int v) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[v];
        
        // Initialize distances to all nodes as infinity except for the source node
        for (int i = 0; i < v; i++) {
            dist[i] = (i == src) ? 0 : Integer.MAX_VALUE;
        }

        boolean[] vis = new boolean[v];
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.remove();
            int u = cur.node;

            if (!vis[u]) {
                vis[u] = true;

                // Process all adjacent nodes of the current node
                for (Edge edge : graph[u]) {
                    int vNode = edge.des;
                    int weight = edge.wei;

                    // Relaxation step
                    if (!vis[vNode] && dist[u] + weight < dist[vNode]) {
                        dist[vNode] = dist[u] + weight;
                        pq.add(new Pair(vNode, dist[vNode]));
                    }
                }
            }
        }
    }

    public static void createGraphW(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 4, 2));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 6));
        graph[2].add(new Edge(2, 4, 6));
        graph[2].add(new Edge(2, 5, 7));
        graph[3].add(new Edge(3, 4, 8));
        graph[3].add(new Edge(3, 5, 2));
        graph[4].add(new Edge(4, 5, -19));
    }

    public static void bellmanford(ArrayList<Edge> graph[], int src, int v) {
        int[] dist = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = (i == src) ? 0 : Integer.MAX_VALUE;
        }

        // Relax edges up to (v-1) times
        for (int i = 0; i < v - 1; i++) {
            for (int j = 0; j < v; j++) {
                for (Edge e : graph[j]) {
                    int u = e.src;
                    int vx = e.des;
                    int weight = e.wei;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[vx]) {
                        dist[vx] = dist[u] + weight;
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int j = 0; j < v; j++) {
            for (Edge e : graph[j]) {
                int u = e.src;
                int vx = e.des;
                int weight = e.wei;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[vx]) {
                    System.out.println("Graph contains a negative weight cycle");
                    return;
                }
            }
        }

        // Print distances
        for (int i = 0; i < v; i++) {
            System.out.println("Shortest distance for " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int v = 6; // Number of vertices
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraphW(graph);
        int src = 0; // Starting node

        longestPath(graph, src, v);
        bellmanford(graph, src, v);
    }
}
