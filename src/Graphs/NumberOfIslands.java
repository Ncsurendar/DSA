package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIslands {

    static int numIslands(char[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(vis[i][j] == 0 && grid[i][j] == '1')
                {
                    count++;
                    bfs(i,j,vis,grid);
                }
            }
        }

        return count;
    }

    static void bfs(int row, int col, int[][] vis, char[][] grid)
    {
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty())
        {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            //traverse in the neighbours and mark them if its land
            for(int delrow = -1; delrow <= 1; delrow++)
            {
                for(int delcol = -1; delcol <= 1; delcol++)
                {
                    int nrow = r + delrow;
                    int ncol = c + delcol;
                    if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0)
                    {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int numberOfIslands = numIslands(grid);
        System.out.println("Number of islands: " + numberOfIslands);
    }
}
