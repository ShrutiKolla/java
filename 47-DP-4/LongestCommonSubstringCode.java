
public class LongestCommonSubstringCode {
    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        // initialize 1st row and 1st col with 0
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(max);
    }    
}
