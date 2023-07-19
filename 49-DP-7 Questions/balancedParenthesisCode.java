public class balancedParenthesisCode {
    public static String printBalancedParenthesis(String str ,int n, String[] dp) {
        if(n == 0) {
            return dp[n] = "";
        } else if(n == 1) {
            // System.out.print("{}");
            return dp[n] = "{}";
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print("{");
                printBalancedParenthesis(i);
                System.out.print("}");
                printBalancedParenthesis(n - i - 1);
            }
        }
    }
    public static void main(String[] args) {
        int n = 3;
        String[] dp = new String[n];
        printBalancedParenthesis("",n, dp);
    }    
}
