package StackandQueues;

import java.util.Stack;

public class InfixToPostfix {

    static int priority(char ch)
    {
        switch(ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp)
    {
        String res = new String("");
        Stack<Character> st = new Stack<>();

        for(int i=0; i<exp.length(); i++)
        {
            char ch = exp.charAt(i);
            if(Character.isLetterOrDigit(ch)) res += ch;
            else if(ch == '(') st.push(ch);
            else if(ch == ')')
            {
                while(!st.isEmpty() && st.peek() != '(')
                {
                    res += st.pop();
                }
                st.pop();
            }
            else
            {
                while(!st.isEmpty() && priority(ch) <= priority(st.peek()))
                {
                    res += st.pop();
                }
                st.push(ch);
            }
        }

        while(!st.isEmpty())
        {
            if(st.peek() == '(') return "Invalid Expression";
            res += st.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Postfix Expression: " + infixToPostfix(exp));
    }
}
