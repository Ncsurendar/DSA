package SlidingWindowAndTwoPointers;

public class MinimumWindowSubString {

    public static String minWindow(String s, String t)
    {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        int[] hash = new int[256];
        for (char c : t.toCharArray())
        {
            hash[c]++;
        }

        int m = t.length();
        int n = s.length();
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, sIndex = -1, count = 0;

        while(r < n)
        {
            if(hash[s.charAt(r)] > 0) count++;
            hash[s.charAt(r)]--;
            while (count == m)
            {
                if (r - l + 1 < minLen)
                {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s,t);
        System.out.println(ans);
    }
}
