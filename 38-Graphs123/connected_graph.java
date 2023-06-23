import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class connected_graph {

    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

     public static void create(ArrayList<Edge>[] graph) {
         /*graph[0].add(new Edge(0, 1));
         // vertex 0
         graph[0].add(new Edge(0, 2));
 
         graph[1].add(new Edge(1, 0));
         graph[1].add(new Edge(1, 3));
 
         graph[2].add(new Edge(2, 0));
         graph[2].add(new Edge(2, 4));
 
         graph[3].add(new Edge(3, 1));
         graph[3].add(new Edge(3, 4));
         graph[3].add(new Edge(3, 5));
 
         graph[4].add(new Edge(4, 2));
         graph[4].add(new Edge(4, 3));
         graph[4].add(new Edge(4, 5));
 
         graph[5].add(new Edge(5, 3));
         graph[5].add(new Edge(5, 4));
         graph[5].add(new Edge(5, 6));
 
         graph[6].add(new Edge(6, 5));*/
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,3));
        
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 0));
     

        graph[4].add(new Edge(4,5));
        // graph[4].add(new Edge(4,8));
        
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
        graph[6].add(new Edge(6, 7));

        graph[7].add(new Edge(7, 6));
        graph[7].add(new Edge(7, 8));

        graph[8].add(new Edge(8, 7));
        // graph[8].add(new Edge(8, 4));
    }

    // multiple connected components --> dfs
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
    public static void DFS(ArrayList<Edge>[] graph) {
        Boolean vis[] = new Boolean[graph.length];
       
        for (int i = 0; i < graph.length; i++) {
            if(vis[i] == null) {
                dfs_util(graph, i, vis);
            }
        }
    }

    // 1. cycle detection

    // helper
    public static Boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, Boolean[] vis, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == null) {
                if(detectCycleUtil(graph, e.dest, vis, curr)) {
                    return true;
                }
            } else if(vis[e.dest] == true && e.dest != par) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }
    public static Boolean detectCycle(ArrayList<Edge>[] graph) {
        Boolean vis[] = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(vis[i] == null) {
                if(!detectCycleUtil(graph, i, vis, i)){
                    return false;
                }
            }
        }
        return true;
    }

    // 2. bipartite graph
    public static Boolean biPartiteUtil(ArrayList<Edge>[] graph, Boolean[] vis, int[] color, int j) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(j);
        color[j] = 0;
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(vis[curr] == null) {
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                    if(color[e.dest] == -1) {
                        color[e.dest] = (color[curr] == 0)? 1 : 0;
                    } else if (color[curr] == color[e.dest]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static Boolean isBiPartite(ArrayList<Edge>[] graph) {
        Boolean vis[] = new Boolean[graph.length];
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            if(vis[i] == null) {
                if (!biPartiteUtil(graph, vis, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[9];
        create(graph);
        DFS(graph);
         System.out.println(
            detectCycle(graph)
        );
        System.out.println(
            isBiPartite(graph)
        );
        /*@SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[7];
        create(graph);
        DFS(graph);
        System.out.println(detectCycle(graph));*/
    }
}
