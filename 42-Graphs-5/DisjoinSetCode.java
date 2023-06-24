import javax.swing.text.html.FormView;

public class DisjoinSetCode {
    static int n = 8;
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

    public static void main(String[] args) {
        init();
        union(1, 3);
        System.out.println(find(3));
        union(2,4);
        union(3, 6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
        System.out.println(rank[1]);
    }
}
