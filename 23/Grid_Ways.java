public class Grid_Ways {

    //grid ways fn --> O(2^(n + m))
    public static int gridWays(int i, int j, int n, int m) {
        //base
        if(i == n -1 && j == m-1) {
            return 1;
        } else if(i == n || j == m) {
            return 0;
        }
        //recursion
        return gridWays(i, j + 1, n, m) + gridWays(i + 1, j, n, m);
    }

    //grid ways trick --> O(n + m)
    public static int gridTrick(int i, int j, int n, int m) {
        int numerator = fact(n - 1 - i + m - 1 - j); 
        int denominator1 = fact(n - 1 - i);
        int denominator2 = fact(m - 1 - j); 
        return numerator / (denominator1 * denominator2);
    }

    //factorial
    public static int fact(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
    //main fn..
    public static void main(String args[]) {
        int n = 3;
        int m = 3;
        System.out.println(gridTrick(0, 1, n, m));
    }
}
