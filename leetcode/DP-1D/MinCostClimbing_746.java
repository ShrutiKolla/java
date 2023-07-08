import java.util.*;
public class MinCostClimbing_746 {
        public static int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] dp = new int[n+1];
            
            Arrays.fill(dp,-1);
    
            // initializing
            dp[n] = 0;
            for(int i = n-1 ; i >= 0; i--) {
                dp[i] = i+2 < n+1 ? Math.min(cost[i] + dp[i+1], cost[i] + dp[i+2]) : cost[i] + dp[i+1];
            }
            return 1 < n+1 ? Math.min(dp[0], dp[1]) : dp[0];
        }
        public static void main(String[] args) {
            int cost[] = {10, 15, 20};
            System.out.println(minCostClimbingStairs(cost));
        }
}
