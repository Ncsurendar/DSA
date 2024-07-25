package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInADAG {

    static void toposort(int node, List<List<Pair>> adj, int[] vis, Stack<Integer> st)
    {
        vis[node] = 1;
        for(int i=0; i<adj.get(node).size(); i++)
        {
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0) toposort(v, adj, vis, st);
        }
        st.push(node);
    }


    static int[] shortestPath(int n, int m, int[][] edge)
    {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0; i<m; i++)
        {
            int u = edge[i][0];
            int v = edge[i][1];
            int wt = edge[i][2];

            adj.get(u).add(new Pair(v,wt));
        }

        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++)
        {
            if(vis[i] == 0)
            {
                toposort(i, adj, vis, st);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while(!st.isEmpty())
        {
            int node = st.pop();
            for(int i=0; i<adj.get(node).size(); i++)
            {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if(dist[node] + wt < dist[v]) dist[v] = dist[node] + wt;
            }
        }

        for(int i=0; i<n; i++)
        {
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int[] res = shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
