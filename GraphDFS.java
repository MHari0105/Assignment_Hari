import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        V = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    public void DFS(int source) {
        boolean[] visited = new boolean[V]; // To keep track of visited vertices
        Stack<Integer> stack = new Stack<>();

        visited[source] = true;
        stack.push(source);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print(vertex + " ");

            for (int neighbor : adjList.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}

public class GraphDFS {
    public static void main(String[] args) {
        int vertices = 7;
        Graph graph = new Graph(vertices);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("Depth First Traversal (starting from vertex 0): ");
        graph.DFS(0);
    }
}
