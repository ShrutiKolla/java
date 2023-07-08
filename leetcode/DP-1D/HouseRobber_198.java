public class HouseRobber_198 {
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // initialize
        if(n > 0) {
            dp[0] = nums[0];
        }
        if(n > 1) {
            dp[1] = Math.max(dp[0], nums[1]);
        }

        for(int i = 2 ; i < n ; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int nums[] = {1,2};
        System.out.println(rob(nums));
    }
}
