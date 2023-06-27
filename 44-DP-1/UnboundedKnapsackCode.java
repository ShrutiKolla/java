public class UnboundedKnapsackCode {
    public static void main(String[] args) {
        int[] val = {15, 14 ,10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        int W = 7; // max allowed weight
        int[][] dp = new int[wt.length + 1][W + 1];

        // intitialize 0th col and 0th row with 0
        for (int i = 1; i < wt.length + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if(w <= j) {
                    int ans1 = v + dp[i][j - w];
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[wt.length][W]);
    }
}
