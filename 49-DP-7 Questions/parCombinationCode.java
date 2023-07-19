public class parCombinationCode {
    public static void printWays(int n, int[] dp) {
        dp[0] = 1;
        if(n >=0 ) {
            dp[1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        System.out.println(dp[n]);
    }
    public static void main(String[] args) {
        int n = 4;
        int dp[] = new int[n+1]; 
        printWays(n, dp);
    }    
}
