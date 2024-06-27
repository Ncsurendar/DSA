package SlidingWindowAndTwoPointers;

public class NumberOfSubstringsContainingAll3Characters {

    static int numberOfSubstrings(String s)
    {
        int[] lastSeen = {-1,-1,-1};
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            lastSeen[c - 'a'] = i;
            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1)
            {
                count = count + (1 + Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int ans = numberOfSubstrings(s);
        System.out.println(ans);
    }
}
