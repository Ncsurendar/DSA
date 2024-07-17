package StackandQueues;

import java.util.Stack;

public class PrefixToInfix {

    static boolean isOperator(char ch)
    {
        return switch (ch) {
            case '+', '-', '*', '/', '^' -> true;
            default -> false;
        };
    }

    static String prefixToInfix(String exp)
    {
        Stack<String> st = new Stack<>();
        for(int i=exp.length()-1; i>=0; i--)
        {
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) st.push(Character.toString(ch));
            else if(isOperator(ch))
            {
                String top1 = st.pop();
                String top2 = st.pop();

                String infix = "(" + top1 + ch + top2 + ")";
                st.push(infix);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Infix Expression: " + prefixToInfix(exp));
    }
}
