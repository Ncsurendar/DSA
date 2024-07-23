package Graphs;

import java.util.HashSet;

public class NumberOfDistinctIslands {

    static void dfs(int row, int col, int[][] vis, int[][] grid, StringBuilder sb, int row0, int col0) {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;

        int a = row - row0;
        int b = col - col0;
        sb.append(a).append(',').append(b).append(' ');

        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, -1, 0, +1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, sb, row0, col0);
            }
        }
    }

    static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, vis, grid, sb, i, j);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[][] grid ={{1, 1, 0, 0, 0},
                       {1, 1, 0, 0, 0},
                       {0, 0, 0, 1, 1},
                       {0, 0, 0, 1, 1}};

        System.out.println(countDistinctIslands(grid));
    }
}
