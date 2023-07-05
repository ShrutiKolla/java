public class buildSegmentTreeCode {

    public static int[] tree;
    public static void init(int n) {
        tree = new int[2*n-1];
    }
    public static void buildST(int[] arr, int sti, int st, int ed) {
        if(st == ed) {
            tree[sti] = arr[st];
            return;
        }

        int mid = (st + ed) /2;
        buildST(arr, 2*sti+1, st, mid);
        buildST(arr, 2*sti+2, mid+1, ed);
        tree[sti] = tree[2*sti+1] + tree[2*sti+2];
    }

    // query
    public static int querySt(int i, int si, int sj, int qi, int qj) {
        if(qi > sj ||qj < si) { //non-overlapping
            return 0;
        } else if(qi <= si && qj >= sj) {
            return tree[i];
        } else {
            int mid = (si+sj)/2;
            int left = querySt(2*i+1, si, mid, qi, qj);
            int right = querySt(2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }
    public static void getSum(int i, int j, int[] arr) {
        int n = arr.length;
        System.out.println(querySt(0, 0, n-1, i, j));
    }

    // update

    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        if(idx < si || idx > sj) {
            return;
        }
        tree[i] += diff;
        if(si != sj) {
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);
            updateUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }
    public static void update(int[] arr, int idx, int newVal) {
        int diff = newVal - arr[idx];
        arr[idx] = newVal;
        updateUtil(0, 0, arr.length-1, idx, diff);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        init(arr.length);
        buildST(arr, 0, 0, arr.length - 1);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        getSum(2, 5, arr);
        update(arr, 2, 2);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }    
}
