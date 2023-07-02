public class MinimumPartitionCode {
    public static void main(String[] args) {
        int nums[] = {1,6,11,5};
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int W = sum/2;

        int dp[][] = new int[n+1][W+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(nums[i-1] <= j) {
                    dp[i][j] = Math.max(nums[i-1] + dp[i-1][j - nums[i-1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;
        System.out.println("sum1 : " + sum1 + "\nsum2 : " + sum2 + "\nMin diff : " + Math.abs(sum1 - sum2));
    }    
}
