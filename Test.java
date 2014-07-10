public class Test {
    public static void main (String[] args) {
        Graph g = new Graph();
        g.insertEdge(1, 2, false);
        g.insertEdge(1, 5, false);
        g.insertEdge(1, 6, false);
        g.insertEdge(2, 5, false);
        g.insertEdge(2, 3, false);
        g.insertEdge(3, 4, false);
        g.insertEdge(4, 5, false);
        g.printGraph();
    }
}
