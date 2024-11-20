import java.util.*;

public class MST_Kruskal {
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

    public static class DisjointSet {
        private int[] parent;
        private int[] rank;

        public DisjointSet(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i; // Each element is its own parent initially
                rank[i] = 0;   // Rank is initially 0 for all
            }
        }

        // Find with path compression
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // Union by rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static int KruskalAlgo(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // Step 1: Convert adjacency list to a list of edges
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1);
                edges.add(new Edge(i, adjNode, weight));
            }
        }

        // Step 2: Sort edges by weight
        Collections.sort(edges, Comparator.comparingInt(e -> e.wei));

        // Step 3: Initialize Disjoint Set
        DisjointSet set = new DisjointSet(v);

        // Step 4: Kruskal's algorithm
        int mstWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {
            if (set.find(edge.src) != set.find(edge.des)) {
                set.union(edge.src, edge.des);
                mstWeight += edge.wei;
                edgesUsed++;

                // Stop if we have v - 1 edges in the MST
                if (edgesUsed == v - 1) {
                    break;
                }
            }
        }

        return mstWeight; // Return total weight of the MST
    }

    // Create a graph as an adjacency list
    public static ArrayList<ArrayList<ArrayList<Integer>>> createGraph(int v, int[][] edges) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int des = edge[1];
            int weight = edge[2];

            // Add edge to adjacency list (for undirected graph)
            adj.get(src).add(new ArrayList<>(Arrays.asList(des, weight)));
            adj.get(des).add(new ArrayList<>(Arrays.asList(src, weight)));
        }

        return adj;
    }

    public static void main(String[] args) {
        int v = 4; // Number of vertices

        // Define edges as {src, des, weight}
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4}
        };

        // Create graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = createGraph(v, edges);

        // Find MST weight using Kruskal's algorithm
        int mstWeight = KruskalAlgo(v, adj);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }
}
