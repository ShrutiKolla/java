import java.util.*;
public class ConnectingCitiesWithMinCostCode {
    // static class Edge {
    //     int src,dest,wt;
    //     public Edge(int s, int d, int w) {
    //         src = s;
    //         dest = d;
    //         wt = w;
    //     }
    //     public String toString() {
    //         return this.src + "--" + this.wt + "-->" + this.dest;
    //     }
    // }

    // public static void create(int[][] cities, ArrayList<Edge>[] graph) {
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     for (int i = 0; i < cities.length; i++) {
    //         for (int j = 0; j < cities[0].length; j++) {
    //             if(cities[i][j] != 0) {
    //                 graph[i].add(new Edge(i, j, cities[i][j]));
    //             }
    //         }
    //     }
    // }

    // static class Pair implements Comparable<Pair> {
    //     int v, cost;
    //     public Pair(int v, int c) {
    //         this.v = v;
    //         cost = c;
    //     }
    //     public int compareTo(Pair p) {
    //         return this.cost - p.cost;
    //     } 
    // }
    // public static void connectingCities_MinCost(ArrayList<Edge>[] graph) {
    //     boolean vis[] = new boolean[graph.length];
    //     PriorityQueue<Pair> pq = new PriorityQueue<>();
    //     pq.add(new Pair(0,0));
    //     int cost = 0;

    //     while(!pq.isEmpty()) {
    //         Pair curr = pq.remove();
    //         if(!vis[curr.v]) {
    //             vis[curr.v] = true;
    //             cost += curr.cost;
    //             for (int i = 0; i < graph[curr.v].size(); i++) {
    //                 Edge e = graph[curr.v].get(i);
    //                 pq.add(new Pair(e.dest, e.wt));
    //             }
    //         }
    //     }
    //     System.out.println(cost);
    // }

    static class Edge implements Comparable<Edge>{
        int dest, cost;
        public Edge(int d, int c) {
            dest = d;
            cost = c;
        }
         public int compareTo(Edge e) {
            return this.cost - e.cost;
        } 
    }

    public static void connectCities(int[][]cities) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0,0));
        boolean vis[] = new boolean[5];
        int cost = 0;
        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest] = true;
                cost += curr.cost;
                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if(cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        System.out.println(cost);
    }

    public static void main(String[] args) {
        int[][] cities = {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0},
        };
        connectCities(cities);
        // int v = 5;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge>[] graph = new ArrayList[v];
        // create(cities, graph);
        // connectingCities_MinCost(graph);
    }
}
