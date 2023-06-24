import java.util.*;

public class KosarajuCode {

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

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
    }

// top sort 
    public static void topSortUtil(ArrayList<Edge>[] graph, boolean vis[], Stack<Integer> s, int curr) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                    topSortUtil(graph, vis, s, e.dest);
            }
        }
        s.push(curr);
    }

// dfs 
    public static void dfsUtil(ArrayList<Edge>[] transpose, boolean[] vis, int curr) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < transpose[curr].size(); i++) {
            Edge e = transpose[curr].get(i);
            if(!vis[e.dest]) {
                    dfsUtil(transpose, vis, e.dest);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[] graph, int v) {
       
        // step-1 : top sort
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];
        for (int i = 0; i < vis.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, vis, s, i);
            }
        }

        // step-2 : transpose
        ArrayList<Edge>[] transpose = new ArrayList[v];
        for (int i = 0; i < transpose.length; i++) {
            transpose[i] = new ArrayList<>();
            vis[i] = false;
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step-3 : dfs on transpose
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                dfsUtil(transpose, vis, curr);
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];
        create(graph);
        kosaraju(graph, 5);
    }
}
