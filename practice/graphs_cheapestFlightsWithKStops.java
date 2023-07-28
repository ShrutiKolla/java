package practice;

import java.util.*;

public class graphs_cheapestFlightsWithKStops {
    static class Edge {
        int src, dest, cost;

        public Edge(int s, int d, int c) {
            src = s;
            dest = d;
            cost = c;
        }
    }

    public static void create(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 100));
        graph[1].add(new Edge(1, 2, 100));
        graph[2].add(new Edge(2, 0, 100));
        graph[1].add(new Edge(1, 3, 600));
        graph[2].add(new Edge(2, 3, 200));
    }

    public static class Pair {
        int v, cost, stops;

        public Pair(int v, int c, int s) {
            this.v = v;
            cost = c;
            stops = s;
        }
    }

    public static void cheapFlight(ArrayList<Edge>[] graph, int src, int dest, int k) {
        Queue<Pair> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        int[] dist = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        q.add(new Pair(0, 0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            if (curr.stops > k) {
                break;
            }
            if (!vis[curr.v]) {
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                }
            }

        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];
        create(graph);
    }
}
