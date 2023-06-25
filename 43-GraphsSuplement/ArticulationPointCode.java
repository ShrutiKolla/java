import java.util.ArrayList;
public class ArticulationPointCode {

    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

// create
    public static void create(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        // graph[3].add(new Edge(3,5));
        graph[4].add(new Edge(4,3));
        // graph[4].add(new Edge(4,5));
        // graph[5].add(new Edge(5,3));
        // graph[5].add(new Edge(5,4));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int par, int time, int[] dt, int[] low, boolean[] vis) {
        int children = 0;
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(neigh == par) {
                continue; //ignore
            } else if(!vis[neigh]) {
                dfs(graph, neigh, curr, time, dt, low, vis);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(par != -1 && dt[curr] <= low[neigh]) {
                    System.out.println("AP ---> " + curr);
                }
                children++;
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
        if(par == -1 && children > 1) {
            System.out.println("AP ---> " + curr);
        }
    }
    public static void articulationPoint(ArrayList<Edge>[] graph) {
        int[] dt = new int[graph.length];
        int[] low = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        int time = 0;

        for (int i = 0; i < vis.length; i++) {
            if(!vis[i]) {
                dfs(graph, i, -1, time, dt, low, vis);
            }
        }
    }
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];
        create(graph);
        articulationPoint(graph);
    }
}
