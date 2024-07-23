package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    int first;
    int second;
    int third;
    Node1(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class DistanceOfNearestCellHaving0 {

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];
        Queue<Node1> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node1(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Node1 node = q.poll();
            int row = node.first;
            int col = node.second;
            int distance = node.third;
            dis[row][col] = distance;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Node1(nrow, ncol, distance + 1));
                }
            }
        }

        return dis;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };

        int[][] ans = updateMatrix(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
