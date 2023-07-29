import java.util.*;

public class maxJumps {
    public static int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        if(n > 0) {
            dp[n-1] = 0;
        }
        for(int i = n-2; i >= 0; i--) {
            int ans = Integer.MIN_VALUE;
            for(int j = i+1; j < n ; j++) {
                if(Math.abs(nums[i]-nums[j])<=target && dp[j] != -1){
                    ans = 1 + dp[j];
                }
                dp[i] = Math.max(dp[i], ans);
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[] nums = {1,0,3,4,2};
        int target = 2;
        System.out.println(maximumJumps(nums, target));
    }
}
