import java.util.*;

class Graph {
    private int V;   // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list

    // Constructor to initialize the graph
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list
    }

    // Helper function for DFS that recursively visits nodes
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all adjacent vertices of v
        for (Integer adjVertex : adj[v]) {
            if (!visited[adjVertex])
                DFSUtil(adjVertex, visited);
        }
    }

    // Function that performs DFS traversal starting from the given vertex
    void DFS(int startVertex) {
        // Mark all vertices as not visited (boolean array)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function for DFS starting from startVertex
        DFSUtil(startVertex, visited);
    }

    public static void main(String args[]) {
        // Create a graph with 4 vertices
        Graph g = new Graph(4);

        // Add edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        // Perform DFS starting from vertex 2
        System.out.println("Depth First Traversal starting from vertex 2:");
        g.DFS(2);
    }
}
