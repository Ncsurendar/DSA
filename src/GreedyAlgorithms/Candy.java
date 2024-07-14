package GreedyAlgorithms;

public class Candy {

    static int candy(int[] ratings)
    {
        int n = ratings.length;
        int down = 0, up = 0, peak = 0, sum = 1;

        for(int i=1; i<n; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                up += 1;
                peak = up + 1;
                down = 0;
                sum += peak;
            }
            else if(ratings[i] == ratings[i-1])
            {
                up = 0;
                down = 0;
                peak = 0;
                sum += 1;
            }
            else
            {
                down += 1;
                up = 0;
                sum += down + 1 - (peak > down ? 1 : 0);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2};
        int ans = candy(arr);
        System.out.println(ans);
    }
}
