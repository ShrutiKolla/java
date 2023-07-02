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

    public static int mcmTab(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // len = 1 --> single matrix
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }
        for (int len = 2; len <= n-1 ; len++) {
            for (int i = 1; i <= n - len; i++) {
                int j = i + len -1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j]);
                }
            }
        }
        return dp[1][n-1];
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
        System.out.println(mcmTab(arr));
    }
}
