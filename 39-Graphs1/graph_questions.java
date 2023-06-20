import java.util.*;
import java.util.LinkedList;
public class graph_questions {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    } 

    public static void create(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        // 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        // 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        // 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        // 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        // 6
        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph) { // --> O(V+E)
        int V = graph.length;
        Boolean visited[] = new Boolean[V];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            if(visited[curr] == null) {
                System.out.println(curr);
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    queue.add(e.dest);
                }
            }
        }
    }

    static Boolean vis[] = new Boolean[7];
    public static void dfs(ArrayList<Edge>[] graph, int curr) { // O(V+E)
        System.out.println(curr);
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == null) {
                dfs(graph, e.dest);
            }
        }
    }

    static Boolean hasPath(ArrayList<Edge>[] graph, int src, int dest) {
        if(src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(vis[e.dest] == null && hasPath(graph, e.dest, dest)) {
                return true;
            }
        }
        return false;
    }

        
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        create(graph);
        // bfs(graph);
        // dfs(graph, 0);
        System.out.println(hasPath(graph, 0, 7));
    }
}
