public class Test {
    public static void main (String[] args) {
        Graph g = new Graph();
        g.readGraph(false);
        g.printGraph();
        int start = 1; // your start node for YOUR graph
        BfsTraversal.initializeSearch(g);
        BfsTraversal.bfs(g, start);
    }
}
