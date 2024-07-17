package StackandQueues;

import java.util.Stack;

public class InfixToPrefix {

    static String reverseAndReplace(String exp)
    {
        StringBuilder res = new StringBuilder();
        for(int i=exp.length() - 1; i>=0; i--)
        {
            char ch = exp.charAt(i);
            if(ch == '(') res.append(')');
            else if(ch == ')') res.append('(');
            else res.append(ch);
        }

        return res.toString();
    }

    static String reverse(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    static String infixToPrefix(String exp)
    {
        exp = reverseAndReplace(exp);
        String postFix = infixToPostFix(exp);
        return reverse(postFix);
    }

    static int priority(char ch)
    {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    static String infixToPostFix(String exp) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) res.append(ch);
            else if (ch == '(') st.push(ch);
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                    res.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            if (st.peek() == '(') return "Invalid Expression";
            res.append(st.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + infixToPrefix(exp));
    }
}
