package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) {
                q.add(new Pair(i, 0));
                vis[i][0] = 1;
            }

            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0) {
                q.add(new Pair(i, m - 1));
                vis[i][m - 1] = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0) {
                q.add(new Pair(0, j));
                vis[0][j] = 1;
            }

            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0) {
                q.add(new Pair(n - 1, j));
                vis[n - 1][j] = 1;
            }
        }

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};
        while (!q.isEmpty()) {
            Pair node = q.poll();
            int row = node.first;
            int col = node.second;

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        int ans = numEnclaves(grid);
        System.out.println(ans);
    }
}
