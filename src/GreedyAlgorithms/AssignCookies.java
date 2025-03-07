package GreedyAlgorithms;

import java.util.Arrays;

public class AssignCookies {

    static int findContentChildren(int[] greed, int[] cookieSize)
    {
        int n = greed.length, m = cookieSize.length;
        Arrays.sort(greed);
        Arrays.sort(cookieSize);
        int l = 0, r = 0;

        while(l < m && r < n)
        {
            if(greed[r] <= cookieSize[l]) r++;
            l++;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] greed = {1, 5, 3, 3, 4};
        int[] cookieSize = {4, 2, 1, 2, 1, 3};

        System.out.print("Array Representing Greed: ");
        for (int k : greed) {
            System.out.print(k + " ");
        }
        System.out.println();

        System.out.print("Array Representing Cookie Size: ");
        for (int j : cookieSize) {
            System.out.print(j + " ");
        }

        int ans = findContentChildren(greed, cookieSize);

        System.out.println();
        System.out.println("No. of kids assigned cookies " + ans);
        System.out.println();
    }
}
