package BitManipulation;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor)
    {
        if(dividend == divisor) return 1;
        boolean sign = true;
        if(dividend >= 0 && divisor < 0) sign = false;
        if(dividend < 0 && divisor >= 0) sign = false;

        int n = Math.abs(dividend);
        int d = Math.abs(divisor);
        int ans = 0;
        while(n >= d)
        {
            int count = 0;
            while(n >= (d << (count+1)))
            {
                count++;
            }
            ans += (1 << count);
            n = n - (d * (1 << count));
        }

        if(ans == (1<<31) && sign) return Integer.MAX_VALUE;
        if(ans == (1<<31) && !sign) return Integer.MIN_VALUE;

        return sign ? ans : (-1 * ans);
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        int ans = divide(dividend, divisor);
        System.out.println(ans);
    }
}
