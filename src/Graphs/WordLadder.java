package Graphs;

import java.util.*;

class Pair2{
    String first;
    int second;
    Pair2(String first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(beginWord, 1));
        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);

        while(!q.isEmpty())
        {
            Pair2 current = q.poll();
            String word = current.first;
            int steps = current.second;

            if(word.equals(endWord)) return steps;
            for(int i=0; i<word.length(); i++)
            {
                char[] replacedArray = word.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);

                    if(set.contains(replacedWord))
                    {
                        set.remove(replacedWord);
                        q.add(new Pair2(replacedWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
