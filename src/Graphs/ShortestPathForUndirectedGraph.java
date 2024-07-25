package Graphs;

import java.util.*;

public class ShortestPathForUndirectedGraph {

    static int[] shortestPath(int[][] edges, int n, int m, int src)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int it : adj.get(node))
            {
                if(dist[node] + 1 < dist[it])
                {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        for(int i=0; i<n; i++)
        {
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 3},
                {2, 3},
                {3, 4}
        };
        int src = 0;
        int[] distances = shortestPath(edges, n, m, src);

        System.out.println("Shortest path distances from node " + src + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + " : " + distances[i]);
        }
    }
}
