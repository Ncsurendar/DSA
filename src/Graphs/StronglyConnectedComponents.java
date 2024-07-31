package Graphs;
import java.util.*;

public class StronglyConnectedComponents {

    static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st)
    {
        vis[node] = 1;
        for(Integer it : adj.get(node))
        {
            if(vis[it] == 0) dfs(it, vis, adj, st);
        }
        st.push(node);
    }

    static void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node] = 1;
        for(Integer it : adj.get(node))
        {
            if(vis[it] == 0) dfs3(it, vis, adj);
        }
    }


    static int kosaraju(int n ,ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[n];
        for(int i=0; i<n; i++)
        {
            if(vis[i] == 0) dfs(i, vis, adj, st);
        }

        // Step 2 : Reversing The Graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjT.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++)
        {
            vis[i] = 0;
            for(Integer it : adj.get(i))
            {
                adjT.get(it).add(i);
            }
        }

        // Step 3 : Calculating SCC (Strongly connected components)
        int scc = 0;
        while(!st.isEmpty())
        {
            int node = st.pop();
            if(vis[node] == 0)
            {
                scc++;
                dfs3(node, vis, adjT);
            }
        }

        return scc;
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int ans = kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);
    }
}
