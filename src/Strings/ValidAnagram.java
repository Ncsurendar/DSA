package Strings;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        if(s.length() != t.length()) System.out.println("False");
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        if(Arrays.equals(sChars,tChars)) System.out.println("True");
        else System.out.println("False");
    }
}
