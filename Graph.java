import java.util.Scanner;

/**
 * @serhanbaker, 26.Jun.2014.
 */

public class Graph {
    static final int MAXV = 1000; // maximum possible vertex count
    Node[] adjList = new Node[MAXV + 1];
    boolean directed;
    int nVertices;
    int nEdges;

    public Graph() { // initialize
        nEdges = nVertices = 0;
        this.directed = directed;
        for (int i = 1; i < MAXV; i++) {
            adjList[i] = null;
        }
    }

    void readGraph(boolean directed) {
        int x,y;
        Scanner in = new Scanner(System.in);
        nVertices = in.nextInt();
        int edgeCount = in.nextInt();
        for (int i = 0; i < edgeCount; i++) {
            x = in.nextInt();
            y = in.nextInt();
            insertEdge(x, y, directed);
        }
    }

    void insertEdge(int x, int y, boolean directed) {
        Node p = new Node(y);
        p.next = adjList[x];
        adjList[x] = p;
        /* insert x,y pair and y,x pair so that we can have undirected graph */
        if (!directed) {
            insertEdge(y, x, true);
        } else {
            nEdges++;
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
