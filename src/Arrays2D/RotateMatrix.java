package Arrays2D;

public class RotateMatrix {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int temp;
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=i; j<matrix.length; j++)
            {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<matrix.length; i++)
        {
            int left = 0, right = matrix.length-1;
            while(left < right)
            {
                temp = matrix[i][right];
                matrix[i][right] = matrix[i][left];
                matrix[i][left] = temp;
                left++;
                right--;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
