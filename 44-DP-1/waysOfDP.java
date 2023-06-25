
public class waysOfDP {

// we will perform fibonacci code in 
    // 1. memoization
    public static int fibmemo(int n, int[] fib) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(fib[n] != 0) {
            return fib[n];
        }
        return fib[n] = fibmemo(n-1, fib) + fibmemo(n-2, fib);
    }
    public static void main(String[] args) {
        int n = 7;
        int[] fib = new int[n + 1];
        // System.out.println(fibmemo(n, fib));

        // 2. tabulation
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        System.out.println(fib[n]);
    }
}
