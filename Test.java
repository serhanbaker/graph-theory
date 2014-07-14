/**
 * @serhanbaker
 */
public class Test {
    public static void main(String[] args) {
        Graph g = new Graph(false);
        g.readGraph();
        g.printGraph();
        BfsTraversal.connectedComponents(g);
        int start = 1;
        System.out.println("\nPath Finding: ");
        BfsTraversal.finderHelper(start, g);
    }
}
