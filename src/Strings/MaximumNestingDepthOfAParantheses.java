package Strings;

import java.util.Stack;

public class MaximumNestingDepthOfAParantheses {

    public static int maxDepth(String s)
    {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(char a : s.toCharArray())
        {
            if(a == '(') st.push(a);
            else if(a == ')')
            {
                ans = Math.max(ans,st.size());
                st.pop();
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        int ans = maxDepth(s);
        System.out.println(ans);
    }
}
