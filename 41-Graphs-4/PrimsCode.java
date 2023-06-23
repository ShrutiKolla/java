import java.util.*;
public class PrimsCode {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
        public String toString() {
            return this.src + "--" + this.wt + "-->" + this.dest;
        }
    }

    public static void create(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1, 10));
        graph[0].add(new Edge(0,2, 15));
        graph[0].add(new Edge(0,3, 30));
        graph[1].add(new Edge(1,0, 10));
        graph[1].add(new Edge(1,3, 40));
        graph[3].add(new Edge(3,1, 40));
        graph[3].add(new Edge(3,0, 30));
        graph[3].add(new Edge(3,2, 50));
        graph[2].add(new Edge(2,0, 15));
        graph[2].add(new Edge(2,3, 50));
    }

    static class Pair implements Comparable<Pair> {
        int v,cost, src;
        public Pair(int v, int d, int s) {
            this.v = v;
            this.cost = d;
            src = s;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
        public String toString() {
            return this.v + " " + this.cost;
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, -1));
        int cost = 0;
        ArrayList<Edge> edges = new ArrayList<>();
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                cost += curr.cost;
                edges.add(new Edge(curr.src, curr.v, curr.cost));
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt, e.src));
                }
            }
        }
        System.out.println("cost: " + cost);
        System.out.println(edges);
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[4];
        create(graph);
        prims(graph);
    }
}
