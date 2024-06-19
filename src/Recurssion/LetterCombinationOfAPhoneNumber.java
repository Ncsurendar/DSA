package Recurssion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {

    static void helper(int index, String digits, List<String> ans, StringBuilder comb, Map<Character, String> digitToLetters)
    {
        if (index == digits.length()) {
            ans.add(comb.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(index));
        for (char letter : letters.toCharArray())
        {
            comb.append(letter);
            helper(index + 1, digits, ans, comb, digitToLetters);
            comb.deleteCharAt(comb.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits)
    {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        helper(0, digits, ans, new StringBuilder(), digitToLetters);
        return ans;
    }

    public static void main(String[] args) {
        String digits1 = "23";
        System.out.println("Combinations for '23': " + letterCombinations(digits1));
    }
}
