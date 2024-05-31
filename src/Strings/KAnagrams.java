package Strings;

public class KAnagrams {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "geageae";
        int k = 3;

        if(s.length() != t.length()) System.out.println("False");

        int [] freq = new int[26];
        for(int i=0; i<s.length(); i++)
        {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        int changes = 0;
        for(int i=0; i<26; i++)
        {
            if(freq[i] > 0) changes += freq[i];
        }
        if(changes <= k) System.out.println("True");
        else System.out.println("False");
    }
}

