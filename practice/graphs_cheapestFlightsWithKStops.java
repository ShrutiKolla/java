
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
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 3, 1));
        // graph[0].add(new Edge(0, 1, 100));
        // graph[1].add(new Edge(1, 2, 100));
        // graph[2].add(new Edge(2, 0, 100));
        // graph[1].add(new Edge(1, 3, 600));
        // graph[2].add(new Edge(2, 3, 200));
    }

    public static class Pair {
        int v, cost, stops;

        public Pair(int v, int c, int s) {
            this.v = v;
            cost = c;
            stops = s;
        }
    }

    public static int cheapFlight(ArrayList<Edge>[] graph, int src, int dest, int k) {
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
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int s = e.src;
                int d = e.dest;
                int c = e.cost;
                //relaxation
                if(dist[d] > curr.cost + c) {
                    dist[d] = curr.cost + c;
                    q.add(new Pair(d, dist[d], curr.stops+1));
                } 
            }
        }

        if(dist[dest] != Integer.MAX_VALUE) {
            return dist[dest];
        }
        return -1;
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[4];
        create(graph);
        System.out.println(cheapFlight(graph, 0, 3, 1));
    }
}
