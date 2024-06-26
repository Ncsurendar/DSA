package SlidingWindowAndTwoPointers;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter {

    static int lengthOfLongestSubstring(String s)
    {
        int left = 0, right = 0, maxLen = 0;
        Set<Character> seen = new HashSet<>();
        while(right < s.length())
        {
            char c = s.charAt(right);
            while(seen.contains(c))
            {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(c);
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            right += 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }
}
