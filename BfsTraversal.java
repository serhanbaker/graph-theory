/**
 * @serhanbaker, 09.Jul.2014.
 *
 * Graph should be in "HashMap<Integer, LinkedList<Integer>>" form
 */

import java.io.*;
import java.util.*;

public class BfsTraversal {
    static HashMap<Integer, Boolean> discovered = new HashMap<Integer, Boolean>();
    static HashMap<Integer, Boolean> processed = new HashMap<Integer, Boolean>();
    static HashMap<Integer, Integer> parents = new HashMap<Integer, Integer>();

    static void bfs(Graph g, int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        int v, vNeighbor;
        List<Integer> p;
        q.add(start);
        discovered.put(start, true);
        while(!q.isEmpty()) {
            v = q.remove();
            System.out.printf("discovered vertex %d\n", v);
            p = g.getNeighbors(v);
            for (int e : p) {
                vNeighbor = e;
                if (!processed.get(vNeighbor)) {
                    System.out.printf("processed edge (%d, %d)\n", v, vNeighbor);
                }
                if (!discovered.get(vNeighbor)) {
                    q.add(vNeighbor);
                    discovered.put(vNeighbor, true);
                    parents.put(vNeighbor, v);
                }
            }
            processed.put(v, true);
            System.out.printf("processed vertex %d\n\n", v);
        }
    }

    static void initializeSearch(Graph g) {
        for (Map.Entry<Integer, LinkedList<Integer>> entry : g.adjList.entrySet()) {
            Integer key = entry.getKey();
            processed.put(key, false);
            discovered.put(key, false);
            parents.put(key, -1);
        }
    }

    static void findPath(int start, int end, HashMap<Integer, Integer> parents) {
        if (start == end || end == -1)
            System.out.printf("\n%d", start);
        else {
            findPath(start, parents.get(end), parents);
            System.out.printf(" %d", end);
        }
    }

    static void finderHelper(int start, Graph g) {
        for (Map.Entry<Integer, LinkedList<Integer>> entry : g.adjList.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> p = g.adjList.get(key);
            if (p != null) {
                findPath(start, key, parents);
            }
        }
    }

    static void connectedComponents(Graph g) {
        int c;
        initializeSearch(g);
        c = 0;
        for (Map.Entry<Integer, LinkedList<Integer>> entry : g.adjList.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> p = g.adjList.get(key);
            if (p != null) {
                if(!discovered.get(key)) {
                    c++;
                    System.out.printf("\n******Component %d:\n", c);
                    bfs(g, key);
                }
            }
        }
    }
}
