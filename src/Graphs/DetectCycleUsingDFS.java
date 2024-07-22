package Graphs;

import java.util.ArrayList;

public class DetectCycleUsingDFS {

    static boolean dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        for(int adjacentNode : adj.get(node))
        {
            if(vis[adjacentNode] == 0)
            {
                if(dfs(adjacentNode, node, vis, adj)) return true;
                else if(adjacentNode != parent) return true;
            }
        }

        return false;
    }

    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        for(int i=0; i<V; i++)
        {
            if(vis[i] == 0)
            {
                if(dfs(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
