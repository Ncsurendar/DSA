package StackandQueues;

import java.util.Stack;

public class PostfixToPrefix {

    static boolean isOperator(char ch)
    {
        return switch(ch)
        {
            case '+','-','*','/','^' -> true;
            default -> false;
        };
    }

    static String postfixToPrefix(String exp)
    {
        Stack<String> st = new Stack<>();
        for(int i=0; i<exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) st.push(Character.toString(ch));
            else if(isOperator(ch))
            {
                String top2 = st.pop();
                String top1 = st.pop();

                String prefix = ch + top1 + top2;
                st.push(prefix);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String exp = "ABC/-AK/L-*";
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Prefix Expression: " + postfixToPrefix(exp));
    }
}
