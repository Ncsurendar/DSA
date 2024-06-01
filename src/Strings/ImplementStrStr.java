package Strings;

public class ImplementStrStr {

    public static int strstr(String s1, String s2)
    {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len2 > len1) return -1;

        for(int i=0; i<=len1 - len2; i++)
        {
            int j=0;
            while(j < s2.length() && s1.charAt(i+j) == s2.charAt(j)) j++;
            if(j == s2.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "leeto";
        int ans = strstr(s1,s2);
        System.out.println(ans);
    }
}
