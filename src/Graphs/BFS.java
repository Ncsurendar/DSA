package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty())
        {
            Integer node = q.poll();
            ans.add(node);

            for(Integer it : adj.get(node))
            {
                if(!vis[it])
                {
                    q.add(it);
                    vis[it] = true;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList<Integer> ans = bfsOfGraph(5, adj);
        int n = ans.size();
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
}
