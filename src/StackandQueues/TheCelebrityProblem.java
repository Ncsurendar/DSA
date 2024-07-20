package StackandQueues;

public class TheCelebrityProblem {

    static int findCelebrity(int[][]matrix)
    {
        int n = matrix.length;
        int top = 0, down = n - 1;
        while(top < down)
        {
            if(matrix[top][down] == 1) top = top + 1;
            else down--;
        }

        if(top > down) return -1;
        for(int i=0; i<n; i++)
        {
            if(matrix[top][i] == 1 && matrix[i][top] == 0) return -1;
        }

        return top + 1; // In terms of 1 based indexing
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {0, 0, 0, 0},
                {1, 0, 1, 0}
        };

        int celebrity = findCelebrity(matrix);

        if (celebrity == -1) {
            System.out.println("No celebrity found.");
        } else {
            System.out.println("The celebrity is person " + celebrity);
        }
    }
}
