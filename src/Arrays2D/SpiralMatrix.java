package Arrays2D;

public class SpiralMatrix {
    public static void main(String[] args) {
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int n = arr.length;
        int m = arr[0].length;
        int left = 0, right = m-1;
        int top = 0, bottom = n-1;

        while(left <= right && top <= bottom)
        {
            for(int i=left; i<=right; i++)
            {
                System.out.print(arr[top][i]+" ");
            }
            top++;

            for(int i=top; i<=bottom; i++)
            {
                System.out.print(arr[i][right]+" ");
            }
            right--;

            if(top <= bottom)
            {
                for(int i=right; i>=left; i--)
                {
                    System.out.print(arr[bottom][i]+" ");
                }
                bottom--;
            }

            if(left <= right)
            {
                for(int i=bottom; i>=top; i--)
                {
                    System.out.print(arr[i][left]+" ");
                }
                left++;
            }
        }
    }
}
