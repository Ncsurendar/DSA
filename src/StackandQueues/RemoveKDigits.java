package StackandQueues;

import java.util.Stack;

public class RemoveKDigits {

    static String removeKDigits(String num, int k)
    {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<num.length(); i++)
        {
            while(!st.isEmpty() && k > 0 && (st.peek() - '0') > num.charAt(i) - '0')
            {
                st.pop();
                k = k - 1;
            }
            st.push(num.charAt(i));
        }

        while(k > 0)
        {
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb = sb.append(st.pop());
        }
        sb.reverse();

        while(sb.length() > 1 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219", 3));
    }
}
