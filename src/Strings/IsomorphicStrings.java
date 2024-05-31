package Strings;

import java.util.HashMap;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s1, String s2)
    {
        HashMap<Character, Character> m1 = new HashMap<>();
        HashMap<Character, Character> m2 = new HashMap<>();
        for(int i=0; i<s1.length(); i++)
        {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(m1.containsKey(a) && m1.get(a)!=b || m2.containsKey(b) && m2.get(b)!=a) return false;
            m1.put(a,b);
            m2.put(b,a);
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "add";
        boolean ans = isIsomorphic(s1,s2);
        System.out.println(ans);
    }
}
