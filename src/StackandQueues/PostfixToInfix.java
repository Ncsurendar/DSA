package StackandQueues;

import java.util.Stack;

public class PostfixToInfix {

    static boolean isOperator(char ch)
    {
        switch(ch)
        {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }

    static String postfixToInfix(String exp)
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

                String infix = "(" + top1 + ch + top2 + ")";
                st.push(infix);
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String exp = "ab+cde+**";
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Infix Expression: " + postfixToInfix(exp));
    }
}
