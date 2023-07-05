public class QueriesonSTCode {

    public static int tree[];
    public static void init(int n) {
        tree = new int[2*n-1];
    }
    public static void buidlSt(int[] arr, int i, int st, int ed) {
        if(st == ed ) {
            tree[i] = arr[st];
            return;
        }
        int mid= (st+ed)/2;
        buidlSt(arr, 2*i+1, st, mid);
        buidlSt(arr, 2*i+2, mid+1, ed);

        tree[i] = tree[2*i+1] + tree[2*i+2];
    }

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
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        init(arr.length);
        buidlSt(arr, 0, 0, arr.length-1);
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
        int i = 2;
        int j = 5;
        System.out.println("ans: " + querySt(0, 0, arr.length-1, i, j));
    }    
}
