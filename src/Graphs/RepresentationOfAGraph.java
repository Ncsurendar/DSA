package Graphs;

import java.util.ArrayList;

public class RepresentationOfAGraph {
    public static void main(String[] args) {
        int m = 3, n = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i=0; i<=n; i++)
        {
           adj.add(new ArrayList<>());
        }

        // This is for undirected graph, encase directed graph store only one time
        //edge 1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        //edge 2---3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //edge 1---3
        adj.get(1).add(3);
        adj.get(3).add(1);

        //printing all the edges
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<adj.get(i).size(); j++)
            {
                System.out.println(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
