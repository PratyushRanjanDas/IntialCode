import java.util.ArrayList;

class Edge {
    int src;
    int des;

    Edge(int src, int des) {
        this.src = src;
        this.des = des;
    }
}

public class GraphPaths {

    public static void createGraph(ArrayList<Edge> Graph[]) {
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<Edge>();
        }
        Graph[0].add(new Edge(0, 1));
        Graph[0].add(new Edge(0, 2));
        Graph[1].add(new Edge(1, 3));
        Graph[1].add(new Edge(1, 0));
        Graph[2].add(new Edge(2, 0));
        Graph[2].add(new Edge(2, 4));
        Graph[3].add(new Edge(3, 1));
        Graph[3].add(new Edge(3, 4));
        Graph[3].add(new Edge(3, 5));
        Graph[4].add(new Edge(4, 3));
        Graph[4].add(new Edge(4, 5));
        Graph[4].add(new Edge(4, 2));
        Graph[5].add(new Edge(5, 4));
        Graph[5].add(new Edge(5, 3));
        Graph[5].add(new Edge(5, 6));
        Graph[6].add(new Edge(6, 5));
    }

    public static void allPath(ArrayList<Edge> Graph[], boolean vis[], int start, int target, String path) {
        if (start == target) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < Graph[start].size(); i++) {
            Edge e = Graph[start].get(i);
            if (!vis[e.des]) {
                vis[start] = true;
                allPath(Graph, vis, e.des, target, path + e.des + "->");
                vis[start] = false;
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] Graph = new ArrayList[vertices];
        createGraph(Graph);

        boolean[] vis = new boolean[vertices];
        int start = 0; // Starting node
        int target = 5; // Target node
        System.out.println("All paths from " + start + " to " + target + ":");
        allPath(Graph, vis, start, target, start + "->");
    }
}
