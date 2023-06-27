public class KnapsackCode {
    public static int knapsack(int[] wt, int[] val, int W, int n) {
        if(W == 0 || n == 0) {
            return 0;
        }
        if(wt[n - 1] <= W) { // we can include
            int ans1 = val[n-1] + knapsack(wt, val, W - wt[n-1], n - 1);
            int ans2 = knapsack(wt, val, W, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsack(wt, val, W, n-1);
        }
    }

    public static int knapsackMemo(int[] wt, int[] val, int W, int n, int[][] dp) {
        if(W == 0 || n == 0) {
            return 0;
        }
        if(dp[n][W] != -1) {
            return dp[n][W];
        }
        if(wt[n - 1] <= W) { // we can include
            int ans1 = val[n-1] + knapsackMemo(wt, val, W - wt[n-1], n - 1, dp);
            int ans2 = knapsackMemo(wt, val, W, n - 1, dp);
            return dp[n][W] = Math.max(ans1, ans2);
        } else {
            return dp[n][W] = knapsackMemo(wt, val, W, n-1, dp);
        }
    }

    public static int knapsackTab(int[] wt, int[] val, int W) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if(w <= j) { // valid
                    int incItem = v + dp[i - 1][j - w];
                    int excItem = dp[i - 1][j];
                    dp[i][j] = Math.max(incItem, excItem);
                } else {
                    int excItem = dp[i - 1][j];
                    dp[i][j] = excItem;
                }
                
            }
        }
        
        return dp[n][W];
    }
    public static void main(String[] args) {
        int wt[] = {2,5,1,3,4};
        int n = wt.length;
        int val[] = {15,14,10,45,30};
        int W = 7;
        System.out.println(knapsack(wt, val, W, n));
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackMemo(wt, val, W, n, dp));
        System.out.println(knapsackTab(wt, val, W));
    }
}
