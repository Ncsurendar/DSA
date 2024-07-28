package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Tuple1 {
    int first, second, third;
    Tuple1(int first, int second, int third) {
        this.first = first;     //stops
        this.second = second;   // node
        this.third = third;     // distance
    }
}

public class CheapestFlightsWithinKStops {

    static int CheapestFLight(int n, int[][] flights, int src, int dst, int k)
    {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i=0; i<m; i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple1> q = new LinkedList<>();
        q.add(new Tuple1(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        while(!q.isEmpty())
        {
            Tuple1 iter = q.poll();
            int stops = iter.first;
            int node = iter.second;
            int cost = iter.third;

            if(stops > k) continue;
            for(Pair it : adj.get(node))
            {
                int adjNode = it.first;
                int edgeWeight = it.second;

                if(cost + edgeWeight < dist[adjNode] && stops <= k)
                {
                    dist[adjNode] = cost + edgeWeight;
                    q.add(new Tuple1(stops + 1, adjNode, cost + edgeWeight));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }


    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        int ans = CheapestFLight(n,flights,src,dst,K);

        System.out.print(ans);
        System.out.println();
    }
}
