import java.util.ArrayList;

public class connected_graph {

    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }
    public static void dfs_util(ArrayList<Edge>[] graph, int src, Boolean[] vis) {
        System.out.println(src);
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(vis[e.dest] == null) {
                dfs_util(graph, e.dest, vis);
            }
        }
    }
    // multiple connected components 
    public static void DFS(ArrayList<Edge>[] graph) {
        Boolean vis[] = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(vis[i] == null) {
                dfs_util(graph, i, vis);
            }
        }
    }
}
