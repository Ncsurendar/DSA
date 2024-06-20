package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n)
    {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        helper(0, board, leftRow, upperDiagonal, lowerDiagonal, ans);

        return ans;
    }

    static void helper(int col, char[][] board, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, List<List<String>> ans)
    {
        if(col == board.length)
        {
            ans.add(construct(board));
            return;
        }

        for(int row=0; row<board.length; row++)
        {
            if(leftRow[row] == 0 && upperDiagonal[(board.length - 1) + (col - row)] == 0 && lowerDiagonal[col + row] == 0)
            {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                lowerDiagonal[row + col] = 1;

                helper(col+1, board, leftRow, upperDiagonal, lowerDiagonal, ans);

                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
                lowerDiagonal[row + col] = 0;
            }
        }
    }

    static List<String> construct(char[][] board)
    {
        List<String> res = new ArrayList<>();
        for(int i=0; i< board.length; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j< board.length; j++)
            {
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> solution : solutions)
        {
            System.out.println("Solution:");
            for (String row : solution)
            {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
