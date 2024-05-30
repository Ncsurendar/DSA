package BinarySearch;

public class Search2DMatrixii {
    public static void main(String[] args) {
        int[][] mat = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        boolean result = searchMatrix(mat,target);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] mat, int target)
    {
        int n = mat.length, m = mat[0].length;
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (mat[row][col] == target) return true;
            else if (mat[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}
