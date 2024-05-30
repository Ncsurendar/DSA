package Strings;

public class ValidPalindromeii {

    public static boolean validPalindrome(String s)
    {
        int left = 0, right = s.length() - 1;
        while (left <= right)
        {
            char currFirst = s.charAt(left);
            char currLast = s.charAt(right);
            if (currFirst == currLast)
            {
                left++;
                right--;
            }
            else return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
        }
        return true;
    }

    public static boolean isPalindrome(String s, int i, int j)
    {
        while(i <= j)
        {
            if(s.charAt(i) == s.charAt(j))
            {
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abca";
        boolean result = validPalindrome(input);
        System.out.println(result);
    }
}
