import java.util.*;
public class directed_graph {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    public static void create(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // for cycle detection
        /*graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[2].add(new Edge(2, 3));

        graph[1].add(new Edge(1, 3));*/
        /*graph[5].add(new Edge(5, 0));
         graph[5].add(new Edge(5, 2))
         graph[2].add(new Edge(2, 3));
         graph[3].add(new Edge(3, 1));
         graph[4].add(new Edge(4, 0));*/

         graph[0].add(new Edge(0, 3));
         graph[0].add(new Edge(0, 4));
         graph[4].add(new Edge(4, 2));
         graph[2].add(new Edge(2, 5));
         graph[1].add(new Edge(1, 3));
         graph[1].add(new Edge(1, 5));

    }

    public static void dfs_util(ArrayList<Edge>[] graph, int curr, Boolean[] vis) {
        vis[curr] = true;
        System.out.println(curr);
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == null) {
                dfs_util(graph, e.dest, vis);
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph) {
        Boolean vis[] = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(vis[i] == null) {
                dfs_util(graph, i, vis);
            }
        }
    }

    // 1. cycle detection
    public static Boolean isCycleUtil(ArrayList<Edge>[] graph, int i, Boolean[] vis, Boolean[] stack) {
        vis[i] = true;
        stack[i] = true;
        for (int j = 0; j < graph[i].size(); j++) {
            Edge e = graph[i].get(j);
            if(stack[e.dest] != null) {
                return true;
            }
            else if (isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[i] = null;
        return false;
    }
    public static Boolean isCycle(ArrayList<Edge>[] graph) {
        Boolean vis[] = new Boolean[graph.length];
        Boolean stack[] = new Boolean[graph.length];
        // for (int i = 0; i < stack.length; i++) {
        //     stack[i] = false;
        // }

        for (int i = 0; i < graph.length; i++) {
            if(vis[i] == null) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 2. topological sort
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, Boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == null) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }s.push(curr);
    }
    public static void topSort(ArrayList<Edge>[] graph) {
        Boolean[] vis = new Boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if(vis[i] == null) {
                topSortUtil(graph, i, vis, s);
            }
        }
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];
        create(graph);
        topSort(graph);
        // dfs(graph);
        // System.out.println(isCycle(graph));
    }
}
