public class CoinChangeCode {
    public static void coinChange(int[] coins, int sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        // initialize 1st col with 1 and 1st row except 0th index with 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int w = coins[i-1];
                if(w <= j) {
                    dp[i][j] = dp[i][j - w] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        coinChange(coins, sum);
    }    
}
