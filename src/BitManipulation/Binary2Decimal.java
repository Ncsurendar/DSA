package BitManipulation;

public class Binary2Decimal {
    public static void main(String[] args) {
        String s = "0101";
        int len = s.length();
        int p2 = 1, sum = 0;

        for(int i=len-1; i>=0; i--)
        {
            if(s.charAt(i) == '1') sum = sum + p2;
            p2 = p2 * 2;
        }

        System.out.println(sum);
    }
}
