package Strings;

public class LargestOddNumberInAString {

    public static String largestOddNumber(String num)
    {
        for(int i=num.length()-1; i>=0; i--)
        {
            int current = num.charAt(i) - '0';
            if(current % 2 != 0)
            {
                return num.substring(0,i+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num = "52";
        String ans = largestOddNumber(num);
        System.out.println(ans);
    }
}
