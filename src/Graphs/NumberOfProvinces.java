package Graphs;

import java.util.ArrayList;

public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected)
    {
        int v = isConnected.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<v; i++)
        {
            list.add(new ArrayList<>());
        }

        // Change the matrix to Adj List
        for(int i=0; i<v; i++)
        {
            for(int j=0; j<v; j++)
            {
                if(isConnected[i][j] == 1 && i != j)
                {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        int[] vis = new int[v];
        int count = 0;
        for(int i=0; i<v; i++)
        {
            if(vis[i] == 0)
            {
                count++;
                dfs(i,list,vis);
            }
        }

        return count;
    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> list, int[] vis)
    {
        vis[node] = 1;
        for(Integer it : list.get(node))
        {
            if(vis[it] == 0)
            {
                dfs(it,list,vis);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int ans = findCircleNum(isConnected);
        System.out.println(ans);
    }
}
