package BinarySearch;

public class SqrtOfX {
    public static void main(String[] args) {
        int x = 4;
        long low = 1, high = x;
        long ans = 0;
        while(low <= high)
        {
            long mid = (low + high)/2;
            long sq = mid*mid;
            if(sq > x)
            {
                high = mid - 1;
            }
            else
            {
                ans = mid;
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
