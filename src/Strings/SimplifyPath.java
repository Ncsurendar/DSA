package Strings;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path)
    {
        Stack<String> st = new Stack<>();
        String[] directories = path.split("/");
        for(String dir : directories)
        {
            if(dir.equals(".") || dir.isEmpty()) continue;
            else if(dir.equals(".."))
            {
                if(!st.isEmpty()) st.pop();
            }
            else st.push(dir);
        }

        return "/" + String.join("/",st);
    }


    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        String ans = simplifyPath(path);
        System.out.println(ans);
    }
}
