/**
 * @serhanbaker
 */
import java.util.*;
class Graph {
    HashMap<Integer, LinkedList<Integer>> adjList;
    boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        adjList = new HashMap<Integer, LinkedList<Integer>>();
    }

    public void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
        if (!directed)
            adjList.get(v2).add(v1);
    }

    public void readGraph() {
        int x, y;
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(); // # of given connections between vertices
        for (int i = 1; i <= m; i++) {
            x = in.nextInt();
            y = in.nextInt();
            if (!adjList.containsKey(x))
                adjList.put(x, new LinkedList<Integer>());
            if (!adjList.containsKey(y))
                adjList.put(y, new LinkedList<Integer>());
            addEdge(x, y);
        }
    }

    public void printGraph() {
        for (Map.Entry<Integer, LinkedList<Integer>> entry : adjList.entrySet()) {
            Integer key = entry.getKey();
            System.out.println(key + "-> " + getNeighbors(key));
        }
    }

    public List<Integer> getNeighbors(int v) {
        return adjList.get(v);
    }
}
