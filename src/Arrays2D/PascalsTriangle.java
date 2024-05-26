package Arrays2D;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static int nCr(int n, int r)
    {
        long res = 1;
        for (int i = 0; i < r; i++)
        {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public static List<List<Integer>> pascalTriangle(int n)
    {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=n; i++)
        {
            List<Integer> tempLst = new ArrayList<>();
            for(int j=1; j<=i; j++)
            {
                tempLst.add(nCr(i - 1, j - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> it : ans)
        {
            for (int ele : it)
            {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
