package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Tuple {
    int dist;
    int row;
    int col;
    Tuple(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

public class ShortestPathInABinaryMatrix {

    public static int shortestPath(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

        Queue<Tuple> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for(int[] row : dist)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = 1;
        q.add(new Tuple(1,0,0));

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while(!q.isEmpty())
        {
            Tuple current = q.poll();
            int dis = current.dist;
            int row = current.row;
            int col = current.col;

            if(row == n-1 && col == m-1) return dis;
            for(int i=0; i<8; i++)
            {
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && dis + 1 < dist[nrow][ncol])
                {
                    dist[nrow][ncol] = dis + 1;
                    q.add(new Tuple(1 + dis, nrow, ncol));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid= {{0,0,0}, {1,1,0},{1,1,0}};

        int res = shortestPath(grid);
        System.out.print(res);
        System.out.println();
    }
}
