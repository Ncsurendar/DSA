package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class DijkstraAlgorithmUsingSet {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        TreeSet<Pair3> set = new TreeSet<>();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        set.add(new Pair3(0, S));

        while (!set.isEmpty()) {
            Pair3 top = set.pollFirst();
            int dis = top.distance;
            int node = top.node;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (dis + edgeWeight < dist[adjNode]) {
                    // Remove the old pair if it exists
                    set.remove(new Pair3(dist[adjNode], adjNode));

                    dist[adjNode] = dis + edgeWeight;
                    set.add(new Pair3(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        int S = 0;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(4, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 6)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 2)));

        int[] distances = dijkstra(V, adj, S);

        System.out.println("The shortest distances from node " + S + " are:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Node " + i + " : " + distances[i]);
        }
    }
}
