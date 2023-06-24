import java.util.*;
import java.util.LinkedList;
public class CheapestKFlightsCode {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    public static void create(ArrayList<Edge>[] graph, int[][] flights) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];
            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class info {
        int v, cost, stops;
        public info(int v, int c, int s) {
            this.v = v;
            cost = c;
            stops = s;
        }
    }

    public static int cheapestFlightsWithinKStops(int n, int[][] flights, 
    int src, int dest, int k ) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        create(graph, flights);

        int dist[] = new int[n];
        for (int i = 0; i < dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<info> q = new LinkedList<>();

        q.add(new info(src,0,0));
        while(!q.isEmpty()) {
            info curr = q.remove();
            if(curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);

                if(curr.cost + e.wt < dist[e.dest] && curr.stops <= k) {
                    dist[e.dest] = curr.cost + e.wt;
                    q.add(new info(e.dest, dist[e.dest], curr.stops+1));
                } 
            }
        }
        if(dist[dest] != Integer.MAX_VALUE) {
            return dist[dest];
        }
        return -1;
    }

    public static void main(String[] args) {
        int src = 0;
        int dest = 3;
        int k = 1; // stops
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        int v = 4;
        System.out.println(cheapestFlightsWithinKStops(v, flights, src, dest, k));
    }
}
