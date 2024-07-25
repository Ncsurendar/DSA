package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {

    private static List<Integer> toposort(int V, List<List<Integer>> adj)
    {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        if (topo.size() != V) return new ArrayList<>();

        return topo;
    }

    public static String findOrder(String [] dict, int N, int K)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = toposort(K, adj);
        if (topo.isEmpty()) return "";

        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            ans.append((char) (it + 'a'));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int N = dict.length;
        int K = 4; // Assuming 'a', 'b', 'c', 'd' are the only characters

        String order = findOrder(dict, N, K);
        if (order.isEmpty()) {
            System.out.println("There is no valid order of characters.");
        } else {
            System.out.println("The order of characters is: " + order);
        }
    }
}
