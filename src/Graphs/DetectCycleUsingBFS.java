package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class DetectCycleUsingBFS {

    static boolean checkForCycle(int src, int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis)
    {
        vis[src] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, -1));

        while(!q.isEmpty())
        {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for(int adjacentNode : adj.get(node))
            {
                if(vis[adjacentNode] == false)
                {
                    vis[adjacentNode] = true;
                    q.add(new Node(adjacentNode, node));
                }
                else if(parent != adjacentNode) return true;
            }
        }

        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0; i<V; i++)
        {
            if(vis[i] == false)
            {
                if(checkForCycle(i, V, adj, vis) == true) return true;
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
