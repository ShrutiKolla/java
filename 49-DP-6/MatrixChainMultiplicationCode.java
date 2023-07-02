import java.util.*;

public class MatrixChainMultiplicationCode {
    public static int mcm(int[] arr, int i, int j) {
        if(i == j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int c1 = mcm(arr, i, k);
            int c2 = mcm(arr, k+1, j);
            int c3 = arr[i-1] * arr[k] * arr[j];
            int finaclC = c1 + c2 + c3;
            ans = Math.min(ans, finaclC);
        }
        return ans;
    }

    public static int mcmMemo(int[] arr, int i, int j, int[][] dp) {
        if(i == j) {
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int c1 = mcmMemo(arr, i, k, dp);
            int c2 = mcmMemo(arr, k+1, j, dp);
            int c3 = arr[i-1] * arr[k] * arr[j];
            int finaclC = c1 + c2 + c3;
            ans = Math.min(ans, finaclC);
        }
        return dp[i][j] = ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(mcm(arr, 1, n-1));
        System.out.println(mcmMemo(arr, 1, n-1, dp));
    }
}
