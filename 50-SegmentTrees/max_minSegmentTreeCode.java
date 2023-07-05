
public class max_minSegmentTreeCode {
    // build a max tree
    public static int[] tree;
    public static void init(int n) {
        tree = new int[2*n-1];
    }
    public static void buildST(int[] arr, int i, int st, int ed) {
        if(st == ed) {
            tree[i] = arr[st];
            return;
        }
        int mid = (st+ed) /2;
        buildST(arr, 2*i+1, st, mid);
        buildST(arr, 2*i+2, mid+1, ed);
        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    // query
    public static int getmaxUtil(int i, int si, int sj, int qi, int qj) {
        if(qj < si || qi > sj) {
            return Integer.MIN_VALUE;
        } else if(qi <= si && qj >= sj) {
            return tree[i];
        } else {
            int mid = (si + sj)/2;
            int left = getmaxUtil(2*i+1, si, mid, qi, qj);
            int right = getmaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }
    }

    // update
    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if(si > idx || sj < idx) {
            return;
        }
        if(si == sj) {
            tree[i] = newVal;
        } else {
            int mid = (si +sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid + 1, sj, idx, newVal);
            tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
        }
    }
    public static void update(int[] arr, int idx, int newval) {
        arr[idx] = newval;
        updateUtil(0, 0, arr.length-1, idx, newval);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");            
        }
    }
    public static void getmax(int[] arr, int i, int j) {
        int n = arr.length;
        System.out.println(getmaxUtil(0, 0, n-1, i, j));
    }
    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
        init(arr.length);
        buildST(arr, 0, 0, arr.length-1);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        getmax(arr, 0, 3);
    }
}
