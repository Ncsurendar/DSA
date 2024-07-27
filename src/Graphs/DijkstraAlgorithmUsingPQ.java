package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair3 {
    int distance;
    int node;
    Pair3(int distance, int node)
    {
        this.distance = distance;
        this.node = node;
    }
}

public class DijkstraAlgorithmUsingPQ {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair3> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        pq.add(new Pair3(0, S));

        while(!pq.isEmpty())
        {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for(int i=0; i<adj.get(node).size(); i++)
            {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if(dis + edgeWeight < dist[adjNode])
                {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair3(dist[adjNode], adjNode));
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
