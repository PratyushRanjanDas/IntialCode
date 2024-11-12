import java.util.ArrayList;
import java.util.Stack;

public class ToggleSort {

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

    public void toggleSort(ArrayList<Edge>[] Graph, int v) {
        Boolean[] vis = new Boolean[v];
        for (int i = 0; i < v; i++) {
            vis[i] = false;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                toggleSortII(Graph, vis, i, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private void toggleSortII(ArrayList<Edge>[] Graph, Boolean[] vis, int current, Stack<Integer> stack) {
        vis[current] = true;
        for (int i = 0; i < Graph[current].size(); i++) {
            Edge e = Graph[current].get(i);
            if (!vis[e.des]) {
                toggleSortII(Graph, vis, e.des, stack);
            }
        }
        stack.push(current); // Push to stack only after all adjacent nodes are visited
    }

    public void creatgraph(ArrayList<Edge>[] Graph) {
        Graph[0].add(new Edge(0, 1));
        Graph[1].add(new Edge(1, 4));
        Graph[4].add(new Edge(4, 2));
        Graph[4].add(new Edge(4, 3));
        Graph[3].add(new Edge(3, 0));
        Graph[3].add(new Edge(3, 2));
    }

    public static void main(String[] args) {
        int v = 5; // number of vertices
        ArrayList<ToggleSort.Edge>[] Graph = new ArrayList[v];
        
        // Initialize each list in the array
        for (int i = 0; i < v; i++) {
            Graph[i] = new ArrayList<>();
        }
        
        ToggleSort toggleSort = new ToggleSort();
        toggleSort.creatgraph(Graph); // create the graph with edges
        System.out.println("Topological Sort of the graph:");
        toggleSort.toggleSort(Graph, v); // perform topological sort
    }
}
