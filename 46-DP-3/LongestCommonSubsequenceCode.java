import java.util.*;
public class LongestCommonSubsequenceCode {

    public static int LCS(String str1, String str2, int n, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }
        if(str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return 1 + LCS(str1, str2, n-1, m-1);
        } else {
            return Math.max(LCS(str1, str2, n-1, m), LCS(str1, str2, n, m-1));
        }
    }
    public static int LCSMemo(String str1, String str2, int n, int m, int[][] val) {
        if(n == 0 || m == 0) {
            return 0;
        }
        if(val[n][m] != -1) {
            return val[n][m];
        }
        if(str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return val[n][m] = 1 + LCSMemo(str1, str2, n-1, m-1, val);
        } else {
            return val[n][m] = Math.max(LCSMemo(str1, str2, n-1, m, val), LCSMemo(str1, str2, n, m-1, val));
        }
    }
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int[][] val = new int[str1.length()+1][str2.length()+1];
        for (int[] row : val) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -1;
            }
        }

        // System.out.println(LCSMemo(str1, str2, str1.length(), str2.length(), val));
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < val[0].length; j++) {
                if(i == 0 || j == 0) {
                    val[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < val.length; i++) {
            for (int j = 1; j < val[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    val[i][j] = val[i-1][j-1] + 1;
                } else {
                    val[i][j] = Math.max(val[i-1][j], val[i][j-1]);
                }
            }
        }
        System.out.println(val[str1.length()][str2.length()]);
    }
}
