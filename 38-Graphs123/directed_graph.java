import java.util.*;
import java.util.LinkedList;
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

        // topological sort-->

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[0].add(new Edge(0, 3));

        /*graph[0].add(new Edge(0, 3));
         graph[0].add(new Edge(0, 4));
         graph[4].add(new Edge(4, 2));
         graph[2].add(new Edge(2, 5));
         graph[1].add(new Edge(1, 3));
         graph[1].add(new Edge(1, 5)); */
        
        // src to dest
        /*graph[0].add(new Edge(0,4));
        graph[1].add(new Edge(1,3));
        graph[3].add(new Edge(3,0));
        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,1));*/

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

        for (int i = 0; i < graph.length; i++) {
            if(vis[i] == null) {
                if(isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 2. topological sort --> DFS
    public static void topSortUtilD(ArrayList<Edge>[] graph, int curr, Boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == null) {
                topSortUtilD(graph, e.dest, vis, s);
            }
        }s.push(curr);
    }
    public static void topSortD(ArrayList<Edge>[] graph) {
        Boolean[] vis = new Boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if(vis[i] == null) {
                topSortUtilD(graph, i, vis, s);
            }
        }
        while(!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    // 3. Topological Sort --> BFS

    public static void findIndeg(ArrayList<Edge>[] graph, int[] indeg) {
        for (int i = 0; i < indeg.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest] ++;
            }
        }
    }
    /*public static void indeg0(int[] indeg, Queue<Integer> q) {
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
                indeg[i] = -1;
            }
        }
    } */
    public static void topSortB(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        findIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        // indeg0(indeg, q);
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest] -= 1;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
            // indeg0(indeg, q);
        }
    }

    // 4. all paths from src to dest
    public static void srcToDest(ArrayList<Edge>[] graph, int src, int dest, Queue<Integer> q) {
        if(src == dest) {
            q.add(src);
            System.out.println(q);
            q.remove(src);
            return;
        }
        q.add(src);
        // System.out.println(q);
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            srcToDest(graph, e.dest, dest, q);
        }
        q.remove(src);
    }

    // exponential tc --> worst case scenario --> O(V^(v))
    public static void srcToDest_Maaam(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if(src == dest) {
            System.out.println(path + src);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            srcToDest_Maaam(graph, e.dest, dest, path + src);
        }
    }
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];
        create(graph);
        // Queue<Integer> q = new LinkedList<>();
        srcToDest_Maaam(graph, 5, 1, "");
        // topSortB(graph);
        // topSortD(graph);
        // dfs(graph);
        // System.out.println(isCycle(graph));
      
    }
}
