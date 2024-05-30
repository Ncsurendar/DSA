package BinarySearch;

public class PeakElement2DMatrix {
    public static void main(String[] args) {

        int[][] mat = {{1,4},{3,2}};
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m-1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            int row = findMax(mat,mid);
            int left = mid - 1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid + 1 < m ? mat[row][mid+1] : -1;
            if(mat[row][mid] > left && mat[row][mid] > right)
            {
                int [] peak = {row, mid};
            }
            else if(left > mat[row][mid]) high = mid - 1;
            else low = mid + 1;
        }
    }

    public static int findMax(int[][] mat,int col)
    {
        int max = 0, index = 0;
        for(int i=0; i<mat.length; i++)
        {
            if(mat[i][col] > max)
            {
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}
