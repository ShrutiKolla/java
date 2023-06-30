import java.util.*;
public class LongestIncreasingSubsequenceCode {
    public static int LCS(int[] arr, int[] arr2, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        // initialize 1st row and 1st col with 0

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(arr[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int LIS(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int i = 0;
        for(int e : set) {
            arr2[i] = e;
            i++;
        }
        Arrays.sort(arr2);
        return LCS(arr, arr2, arr.length, arr2.length);
    }
    public static void main(String[] args) {
        int[] arr = {50, 3, 10, 7, 40, 80};
        System.out.println(LIS(arr));
    }
}
