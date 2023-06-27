public class SubsetTargetSumCode {
    public static void main(String[] args) {
        int arr[] = {4, 2, 7, 1, 3};
        int n = arr.length;
        int sum = 10;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = arr[i - 1];
                if(v <= j && dp[i-1][j-v]) {
                    dp[i][j] = true;
                }
                else if(dp[i-1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        System.out.println(dp[n][sum]);
    }    
}
