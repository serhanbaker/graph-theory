public class BfsTraversal {
    static boolean[] discovered = new boolean[Graph.MAXV];
    static boolean[] processed = new boolean[Graph.MAXV];
    static int[] parents = new int[Graph.MAXV];

    static void bfs(Graph g, int start) {
        Queue q = new Queue(); // to-do list for discovered but not processed
        int v, vNeighbor; // node to process and its neighbor
        Node p;
        q.enqueue(start);
        discovered[start] = true; // starting from "start", so it's discovered
        while(!q.isEmpty()) {
            v = q.dequeue();
            System.out.printf("discovered vertex %d\n", v);
            p = g.adjList[v];
            while(p != null) {
                vNeighbor = p.val;
                if (!processed[vNeighbor])
                    System.out.printf("processed edge (%d, %d)\n", v, vNeighbor);
                if (!discovered[vNeighbor]) {
                    q.enqueue(vNeighbor);
                    discovered[vNeighbor] = true;
                    parents[vNeighbor] = v;
                }
                p = p.next;
            }
            processed[v] = true;
            System.out.printf("processed vertex %d\n\n", v);
        }
    }

    static void initializeSearch(Graph g) {
        for (int i = 1; i <= g.nVertices; i++) {
            processed[i] = discovered[i] = false;
            parents[i] = -1;
        }
    }
}
