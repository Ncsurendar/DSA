package BitManipulation;

public class XORNumberInGivenRange {

    static int fun(int n)
    {
        if(n % 4 == 0) return n;
        else if(n % 4 == 1) return 1;
        else if(n % 4 == 2) return n+1;
        else return 0;
    }

    public static void main(String[] args) {
        int l = 4;
        int r = 8;
        int ans = fun(l-1) ^ fun(r);
        System.out.println(ans);
    }
}
