package Tries;

public class L04NumberOfDistinctSubstrings {

    static int countDistinctSubstrings(String s)
    {
        Node root = new Node();
        int cnt = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            Node node = root;
            for (int j = i; j < n; j++) {
                if (!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Node());
                    cnt++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return cnt + 1;
    }

    public static void main(String[] args) {
        String s = "striver";
        System.out.println("Current String: " + s);
        System.out.println("Number of distinct substrings: " + countDistinctSubstrings(s));
    }
}
