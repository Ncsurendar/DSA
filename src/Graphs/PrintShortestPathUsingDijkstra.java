package Graphs;

import java.util.*;

public class PrintShortestPathUsingDijkstra {

    static List<Integer> shortestPath(int n, int m, int[][] edges)
    {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.first - y.first);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new Pair(0, 1));
        while(!pq.isEmpty())
        {
            Pair it = pq.poll();
            int node = it.second;
            int dis = it.first;

            for(Pair iter : adj.get(node))
            {
                int adjNode = iter.first;
                int edgeWeight = iter.second;
                if(dis + edgeWeight < dist[adjNode])
                {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dis + edgeWeight, adjNode));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE)
        {
            path.add(-1);
            return path;
        }

        int node = n;
        while(parent[node] != node)
        {
            path.add(node);
            node = parent[node];
        }
        path.add(1);

        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int V = 5, E = 6;

        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};

        List< Integer > path = shortestPath(V, E, edges);
        for (Integer integer : path) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
