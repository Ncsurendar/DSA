package DynamicProgramming;
import java.util.*;
public class L45LongestStringChain {

    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }

    public static int longestStrChain(String[] arr) {
        int n = arr.length;
        Arrays.sort(arr, comp);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                if (compare(arr[i], arr[prevIndex]) && 1 + dp[prevIndex] > dp[i]) {
                    dp[i] = 1 + dp[prevIndex];
                }
            }

            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "b", "ba", "bca", "bda", "bdca"};
        int result = longestStrChain(arr);
        System.out.println("Longest string chain length: " + result);
    }
}
