package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    public static void helper(String current, int open, int closed, int n, List<String>ans)
    {
        if(open == n && closed == n)
        {
            ans.add(current);
            return;
        }

        if(open < n)
        {
            helper(current+"(", open+1, closed, n, ans);
        }

        if(closed < open)
        {
            helper(current+")", open, closed+1, n, ans);
        }
    }

    public static List<String> generateParenthesis(int n)
    {
        List<String> ans = new ArrayList<>();
        helper("", 0, 0, n, ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println("Generated balanced parentheses for n = " + n + ":");
        for (String s : result)
        {
            System.out.println(s);
        }

    }
}
