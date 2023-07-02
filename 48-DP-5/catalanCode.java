import java.util.*;
public class catalanCode {
    public static int catalan(int n,int[] arr) {
        if(n == 0|| n == 1) {
            return 1;
        }
        int Cn = 0;
        if(arr[n] != -1) {
            return arr[n]; 
        }
        for (int i = 0; i < n; i++) {
            Cn += catalan(i,arr) * catalan(n-i-1,arr);
        }
        return arr[n] = Cn;
    }

    public static void catalanTab(int n) {
        int[] dp = new int[n+1];
        // initialize dp 0 and 1 as 1
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        System.out.println(dp[n]);
    }
    public static void main(String[] args) {
        int n = 20;
        int arr[] = new int[n + 1];
        Arrays.fill(arr, -1);
        System.out.println(catalan(19, arr));
        catalanTab(19);
    }
}
