package Graphs;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeNodes {

    static boolean dfs(int node, int[][] graph, int[] vis, int[] pathVis, int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int neighbour : graph[node]) {
            if (vis[neighbour] == 0) {
                if (dfs(neighbour, graph, vis, pathVis, check)) return true;
            } else if (pathVis[neighbour] == 1) return true;
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        int[] check = new int[v];

        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                dfs(i, graph, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (check[i] == 1) safeNodes.add(i);
        }

        return safeNodes;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        List<Integer> safeNodes = eventualSafeNodes(graph);
        System.out.println("Safe nodes: " + safeNodes);
    }
}
