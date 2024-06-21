package Recurssion;

public class WordSearch {

    public static boolean exist(char[][] board, String word)
    {
        int m = board.length;
        int n = board[0].length;

        int index = 0;

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] == word.charAt(index))
                {
                    if(helper(board, word, i, j, index, m, n)) return true;
                }
            }
        }
        return false;
    }

    static boolean helper(char[][] board, String word, int row, int col, int index, int m, int n)
    {
        if(index == word.length()) return true;

        if(row < 0 || col < 0 || row == m || col == n || board[row][col] != word.charAt(index) || board[row][col] == '!') return false;

        char c = board[row][col];
        board[row][col] = '!';

        boolean top = helper(board, word, row-1, col, index+1, m, n);
        boolean down = helper(board, word, row+1, col, index+1, m, n);
        boolean left = helper(board, word, row, col-1, index+1, m, n);
        boolean right = helper(board, word, row, col+1, index+1, m, n);

        board[row][col] = c;

        return top || down || left || right;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};

        String word = "ABCCED";
        boolean res = exist(board, word);
        System.out.println(res);
    }

}
