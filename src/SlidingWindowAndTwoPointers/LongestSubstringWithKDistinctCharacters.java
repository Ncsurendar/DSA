package SlidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k)
    {
        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> mpp = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            mpp.put(rightChar, mpp.getOrDefault(rightChar, 0) + 1);

            if (mpp.size() > k) {
                char leftChar = s.charAt(left);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                if (mpp.get(leftChar) == 0) {
                    mpp.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;

    }

    public static void main(String[] args) {
        String s = "aaabbcdabc";
        int k = 2;
        int ans = lengthOfLongestSubstringKDistinct(s,k);
        System.out.println(ans);
    }
}
