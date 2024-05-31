package Strings;

import java.util.Stack;

public class ValidParantheses {

    public static boolean isValid(String s)
    {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray())
        {
            if(c == '(') st.push(')');
            else if(c == '{') st.push('}');
            else if(c == '[') st.push(']');
            else if(st.isEmpty() || st.pop() != c) return false;
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        boolean ans = isValid(s);
        System.out.println(ans);
    }
}
