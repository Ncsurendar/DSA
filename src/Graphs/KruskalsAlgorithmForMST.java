package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge>{
    int src, dest, weight;
    Edge(int src, int dest, int weight) {
        this.src= src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge compareEdge)
    {
        return this.weight - compareEdge.weight;
    }
}

public class KruskalsAlgorithmForMST {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        List<Edge> edges = new ArrayList<Edge>();
        for(int i=0; i<V; i++)
        {
            for(int j=0; j<adj.get(i).size(); j++)
            {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                Edge temp = new Edge(node, adjNode, wt);
                edges.add(temp);
            }
        }

        DisjointSet1 ds = new DisjointSet1(V);
        Collections.sort(edges);
        int mstWt = 0;

        for (Edge edge : edges)
        {
            int wt = edge.weight;
            int u = edge.src;
            int v = edge.dest;

            if(ds.findUPar(u) != ds.findUPar(v))
            {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }

        return mstWt;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        int mstWt = spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + mstWt);
    }
}
