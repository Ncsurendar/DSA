package Graphs;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacentList {

    static List<List<Integer>> createAdjacencyList(int V, int[][] edges)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    public static void main(String[] args) {
        int v = 5;
        int[][] edges = {
                {0, 1},
                {0, 4},
                {4, 1},
                {4, 3},
                {1, 3},
                {1, 2},
                {3, 2}
        };

        List<List<Integer>> adjList = createAdjacencyList(v, edges);
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(i + " -> " + adjList.get(i));
        }
    }
}
