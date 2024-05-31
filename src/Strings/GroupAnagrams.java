package Strings;

import java.util.*;

public class GroupAnagrams {

    public static  List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String,List<String>> map = new HashMap<>();
        for(String word:strs)
        {
            char [] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if(!map.containsKey(sortedWord))
            {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(input);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : groupedAnagrams)
        {
            System.out.println(group);
        }
    }
}
