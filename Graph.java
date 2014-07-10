import java.util.Scanner;

/**
 * @serhanbaker, 26.Jun.2014.
 */

public class Graph {
    static final int MAXV = 1000; // maximum possible vertex count
    Node[] adjList = new Node[MAXV + 1];
    boolean directed;

    public Graph() { // initialize
        this.directed = directed;
        for (int i = 1; i < MAXV; i++) {
            adjList[i] = null;
        }
    }

    void insertEdge(int x, int y, boolean directed) {
        Node p = new Node(y);
        p.next = adjList[x];
        adjList[x] = p;
        /* insert x,y pair and y,x pair so that we can have undirected graph */
        if (!directed) {
            insertEdge(y, x, true);
        }
    }

    void printGraph() {
        for(int i = 1; i < adjList.length; i++) {
            Node p = adjList[i];
            if (p != null)
                System.out.println(i + ": " + p);
        }
    }
}
