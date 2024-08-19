package Tries;

public class L03LongestWordWithAllPrefix {

    static String longestWord(String[] words)
    {
        Trie trie = new Trie();
        for(String word : words)
        {
            trie.insert(word);
        }

        String longestWord = "";
        for(String word : words)
        {
            if(allprefixExist(word, trie))
            {
                if(word.length() > longestWord.length() || (word.length() == longestWord.length() && word.compareTo(longestWord) < 0))
                {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }

    static boolean allprefixExist(String word, Trie trie)
    {
        for(int i=1; i<=word.length(); i++)
        {
            String prefix = word.substring(0, i);
            if(!trie.search(prefix)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words));
    }
}
