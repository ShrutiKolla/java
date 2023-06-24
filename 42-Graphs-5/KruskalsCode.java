import java.util.*;
public class KruskalsCode {

    static int n = 4; // vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
    }
    
    // find fn
    public static int find(int x) {
        if(x == par[x]) {
            return x;
        }
        return find(par[x]);
    }

    // union fn
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }
    static class Edge implements Comparable<Edge>{
        int src,dest,wt;
        public Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
        public int compareTo(Edge e) {
            return this.wt - e.wt;
        }
        public String toString() {
            return this.src + "--" + this.wt + "-->" + this.dest;
        }
    }

    public static void create(ArrayList<Edge> edges) {
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    // kruskals code for mst
    public static void kruskalsMST(ArrayList<Edge> edges) {
        init();
        Collections.sort(edges);
        int count = 0;
        int costMST = 0;
        for (int i = 0; count < n - 1; i++) {
            Edge e = edges.get(i);
            int parSrc = find(e.src);
            int parDest = find(e.dest);

            if(parSrc != parDest) {
                union(e.src, e.dest);
                costMST += e.wt;
                count++;
            }
        }
        System.out.println(costMST);
    }
    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        create(edges);
        kruskalsMST(edges);
    }
}
