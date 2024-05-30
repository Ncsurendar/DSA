package Strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(input);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s)
    {
        int start = 0, end = s.length()-1;
        while(start <= end)
        {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(end);
            if(!Character.isLetterOrDigit(currFirst)) start++;
            else if(!Character.isLetterOrDigit(currLast)) end--;
            else
            {
                if(Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) return false;
                start++;
                end--;
            }
        }
        return true;
    }
}
