public class CountingTreesCode {
    public static void main(String[] args) {
        int[] nodes = {10, 20, 30, 40};
        int n = nodes.length;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        
        System.out.println(dp[n]);
    }
}
