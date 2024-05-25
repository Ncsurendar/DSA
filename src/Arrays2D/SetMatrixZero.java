package Arrays2D;

public class SetMatrixZero {
    public static void main(String[] args) {
        int [][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        boolean fr = false, fc = false;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                if(arr[i][j] == 0)
                {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    arr[0][j] = 0;
                    arr[i][0] = 0;
                }
            }
        }

        for(int i=1; i<arr.length; i++)
        {
            for(int j=1; j<arr[0].length; j++)
            {
                if(arr[i][0] == 0 || arr[0][j] == 0)
                {
                    arr[i][j] = 0;
                }
            }
        }

        if(fr)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                arr[0][j] = 0;
            }
        }

        if(fc)
        {
            for(int i=0; i<arr.length; i++)
            {
                arr[i][0] = 0;
            }
        }

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
