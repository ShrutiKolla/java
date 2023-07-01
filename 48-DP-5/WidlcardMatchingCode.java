
public class WidlcardMatchingCode {
    public static void main(String[] args) {
        // String text = "baaabab";
        // String pattern = "*****ba*****ab";
        // String text = "baaabab";
        // String pattern = "a*ab";
        String text = "abc";
        String pattern = "**?b*";

        int n = text.length();
        int m = pattern.length();

        boolean[][] dp = new boolean[n+1][m+1];
        
        // initialization
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < dp[0].length; j++) {
            if(pattern.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(text.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        System.out.println(dp[n][m]);
    }    
}
