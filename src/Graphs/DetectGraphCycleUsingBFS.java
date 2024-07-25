package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectGraphCycleUsingBFS {

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[V];
        for(int i=0; i<V; i++)
        {
            for(int it : adj.get(i))
            {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++)
        {
            if(indegree[i] == 0) q.add(i);
        }

        int count = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            count++;

            for(int it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(count == V) return false;
        return true;
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);

        if (isCyclic(V, adj)) {
            System.out.println("The graph contains a cycle");
        } else {
            System.out.println("The graph does not contain a cycle");
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }
}
