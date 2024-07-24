package Graphs;

import java.util.ArrayList;

public class CycleDetectionInADirectedGraph {

    static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis)
    {
        vis[node] = 1;
        pathVis[node] = 1;

        for(int neighbour : adj.get(node))
        {
            if(vis[neighbour] == 0)
            {
                if(dfs(neighbour, adj, vis, pathVis)) return true;
            }
            else if(pathVis[neighbour] == 1) return true;
        }

        pathVis[node] = 0;
        return false;
    }

    static boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[n];
        int[] pathVis = new int[n];

        for(int i=0; i<n; i++)
        {
            if(vis[i] == 0)
            {
                if(dfs(i,adj,vis,pathVis)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);

        boolean result = isCyclic(V, adj);

        if (result) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
