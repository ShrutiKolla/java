public class MinArrayJumpsCode {
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        int n = arr.length;
        int dp[] = new int[n];
        dp[n-1] = 0;
        for (int i = 0; i < dp.length-1; i++) {
            dp[i] = -1;
        }

        for (int i = n-2 ; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            int steps = arr[i];
            for (int j = i + 1; j <= i + steps && j < n ; j++) {
                if(dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }
            if(ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }
        System.out.println(dp[0]);
    }    
}
