package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleUsingTopoSort {

    static int[] findOrder(int V, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++)
        {
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for(int i=0; i<m; i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[V];
        for(int i=0; i<V; i++)
        {
            for(int it : adj.get(i))
            {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int[] topo = new int[V];
        int ind = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            topo[ind++] = node;

            for(int it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        if(ind == V) return topo;
        return new int[]{};
    }


    public static void main(String[] args) {
        int V = 4;
        int[][] prerequisites = { {1, 0}, {2, 0}, {3, 1}, {3, 2} };
        int[] order = findOrder(V, prerequisites);
        if (order.length == 0) {
            System.out.println("It's not possible to complete all courses.");
        } else {
            System.out.println("The order of courses to finish all courses is: " + Arrays.toString(order));
        }
    }
}
