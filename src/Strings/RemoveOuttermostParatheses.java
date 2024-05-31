package Strings;

import java.util.Stack;

public class RemoveOuttermostParatheses {

    public static String removeOuterParentheses(String s) {
        Stack <Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                if(!st.isEmpty())
                {
                    sb.append(c);
                }
                st.push(c);
            }
            else
            {
                st.pop();
                if(!st.isEmpty())
                {
                    sb.append(c);
                }
            }

        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String input = "(()())(())";
        String result = removeOuterParentheses(input);
        System.out.println("Output: " + result);
    }
}
