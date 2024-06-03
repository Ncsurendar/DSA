package Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter {

    public static int lengthOfLongestSubstring(String s)
    {
        int start = 0, end = 0;
        int max = 0;
        Set<Character> seen = new HashSet<>();

        while(end < s.length())
        {
            char c = s.charAt(end);
            while(seen.contains(c))
            {
                seen.remove(s.charAt(start));
                start++;
            }
            seen.add(c);
            int len = (end - start) + 1;
            max = Math.max(max,len);
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int longest = lengthOfLongestSubstring(s);
        System.out.println(longest);
    }
}
