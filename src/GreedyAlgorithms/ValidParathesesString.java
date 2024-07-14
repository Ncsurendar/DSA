package GreedyAlgorithms;

public class ValidParathesesString {

    static boolean checkValidString(String s)
    {
        int min = 0, max = 0;
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
            {
                min = min + 1;
                max = max + 1;
            }
            else if(ch == ')')
            {
                min = min - 1;
                max = max - 1;
            }
            else
            {
                min = min - 1;
                max = max + 1;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }

        return (min == 0);
    }

    public static void main(String[] args) {
        String s = "(*)";
        boolean ans = checkValidString(s);
        System.out.println(ans);

    }
}
