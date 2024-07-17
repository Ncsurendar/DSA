package StackandQueues;

import java.util.Stack;

public class PrefixToPostfix {

    static boolean isOperator(char ch)
    {
        return switch(ch)
        {
          case '+','-','*','/','^' -> true;
          default -> false;
        };
    }

    static String prefixToPostfix(String exp)
    {
        Stack<String> st = new Stack<>();
        for(int i=exp.length()-1; i>=0; i--)
        {
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) st.push(Character.toString(ch));
            else if (isOperator(ch))
            {
                String top1 = st.pop();
                String top2 = st.pop();
                String postfix = top1 + top2 + ch;
                st.push(postfix);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Postfix Expression: " + prefixToPostfix(exp));
    }
}
