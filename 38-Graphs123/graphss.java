import java.util.*;
public class graphss {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }    

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,5));

        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        graph[4].add(new Edge(4,2,2));

        // print 2's neighbours
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}
