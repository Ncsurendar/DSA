package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair1 {
    int row;
    int col;
    int time;
    Pair1(int row, int col, int time)
    {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOranges {

    static int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;

        Queue<Pair1> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Pair1(i,j,0));
                    vis[i][j] = 2;
                }
                else
                {
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) fresh++;
            }
        }

        int t = 0;
        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};
        int count = 0;
        while(!q.isEmpty())
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int tm = q.peek().time;
            t = Math.max(t, tm);
            q.remove();

            for(int i=0; i<4; i++)
            {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1)
                {
                    q.add(new Pair1(nrow, ncol, tm + 1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }

        if(fresh != count) return -1;
        return t;
    }

    public static void main(String[] args) {
        int[][] arr={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(arr);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }
}
