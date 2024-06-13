package Arrays;

public class PowOfXN {

    static double myPow(double x, int n)
    {
        long nn = n;
        double ans = 1.0;
        if(nn < 0) nn = -1 * nn;

        while(nn > 0)
        {
            if(nn % 2 == 0)
            {
                x = x * x;
                nn = nn / 2;
            }
            else
            {
                ans = ans * x;
                nn = nn - 1;
            }
        }

        if (n < 0) ans = (double)(1.0) / (double)(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2^10 = " +myPow(2, 10));
    }
}
