package Graphs;
import java.util.*;

public class MakingALargeIsland {

    private static boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }

    public static int MaxConnection(int[][] grid) {
        int n = grid.length;
        DisjointSet1 ds = new DisjointSet1(n * n);
        // step - 1
        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n ; col++) {
                if (grid[row][col] == 0) continue;
                int[] dr = { -1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        // step 2
        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                int[] dr = { -1, 0, 1, 0};
                int[] dc = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n)) {
                        if (grid[newr][newc] == 1) {
                            components.add(ds.findUPar(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : components) {
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
        }
        return mx;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };

        int ans = MaxConnection(grid);
        System.out.println("The largest group of connected 1s is of size: " + ans);
    }
}
