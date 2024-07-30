package Graphs;
import java.util.*;


public class NumberOfOperationsToMakeNetworkConnected {

    static int Solve(int V, int[][] edge)
    {
        DisjointSet1 ds = new DisjointSet1(V);
        int extra = 0;
        int m = edge.length;
        for(int i=0; i<m; i++)
        {
            int u = edge[i][0];
            int v = edge[i][1];
            if(ds.findUPar(u) == ds.findUPar(v)) extra++;
            else ds.unionBySize(u,v);
        }

        int CntC = 0;
        for(int i=0; i<V; i++)
        {
            if(ds.parent.get(i) == i) CntC++;
        }
        int ans = CntC - 1;
        if(extra >= ans) return ans;
        return -1;
    }

    public static void main(String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        int ans = Solve(V, edge);
        System.out.println("The number of operations needed: " + ans);
    }
}
