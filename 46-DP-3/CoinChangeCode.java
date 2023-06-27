public class CoinChangeCode {
    public static void coinChange(int[] coins, int sum) {
        int n = coins.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        // initialize 1st col with 0 and 1st row except 0th index with 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        int ways = 0;
        for (int i = 0; i < dp.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int w = coins[i-1];
                if(w <= j) {}
            }
        }
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        coinChange(coins, sum);
    }    
}
