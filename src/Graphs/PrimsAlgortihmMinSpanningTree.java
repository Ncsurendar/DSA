package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair4 {
    int node, distance;
    Pair4(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class PrimsAlgortihmMinSpanningTree {

    static int spanningTree(int V, int E, List<List<int[]>> adj)
    {
        PriorityQueue<Pair4> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] vis = new int[V];
        pq.add(new Pair4(0,0));
        int sum = 0;

        while(!pq.isEmpty())
        {
            Pair4 current = pq.poll();
            int weight = current.distance;
            int node = current.node;

            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += weight;

            for(int i=0; i<adj.get(node).size(); i++)
            {
                int[] neighbor = adj.get(node).get(i);
                int adjNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if(vis[adjNode] == 0)
                {
                    pq.add(new Pair4(adjNode, edgeWeight));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 7;

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new int[]{1, 2});
        adj.get(1).add(new int[]{0, 2});

        adj.get(0).add(new int[]{3, 6});
        adj.get(3).add(new int[]{0, 6});

        adj.get(1).add(new int[]{2, 3});
        adj.get(2).add(new int[]{1, 3});

        adj.get(1).add(new int[]{3, 8});
        adj.get(3).add(new int[]{1, 8});

        adj.get(1).add(new int[]{4, 5});
        adj.get(4).add(new int[]{1, 5});

        adj.get(2).add(new int[]{4, 7});
        adj.get(4).add(new int[]{2, 7});

        adj.get(3).add(new int[]{4, 9});
        adj.get(4).add(new int[]{3, 9});

        int minCost = spanningTree(V, E, adj);
        System.out.println("The sum of weights of the Minimum Spanning Tree is: " + minCost);
    }
}
