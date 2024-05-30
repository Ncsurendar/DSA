package Strings;

public class PalindromicSubstring {

    public static int CountSubstring(String s)
    {
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            count += countPalindromesAroundCenter(s, i, i);
            count += countPalindromesAroundCenter(s, i, i+1);
        }
        return count;
    }

    public static int countPalindromesAroundCenter(String s, int left, int right)
    {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        int ans = CountSubstring(s);
        System.out.println(ans);
    }
}
