import java.util.*;
public class sum_bin {
    public static int binEqui(int n) {
        int rem = 0;
        int ans = 0;
        int e = 0;
        while(n > 0) {
            rem = n % 2;
            ans += rem * Math.pow(10, e);
            e++;
            n = n / 2;
        }
        return ans;
    }
    public static int decEqui(int n) {
        int e = 0;
        int rem = 0;
        int ans = 0;
        while(n > 0) {
            rem = n % 10;
            ans += rem * Math.pow(2, e);
            e++;
            n /= 10;
        }
        return ans;
    }
    public static int add(int a, int b) {
        int ans = 0;
        int rem_a = 0;
        int rem_b = 0;
        int e = 0;
        int c = 0;
        while(a > 0 && b > 0) {
            rem_a = a % 10;
            rem_b = b % 10;
            if(rem_a == 0 && rem_b == 0) {
                if(c == 1) {
                    int add = 1;
                    ans += add * Math.pow(10, e);
                    e++;   
                    c = 0; 
                } else {
                    int add = 0;
                    ans += add * Math.pow(10, e);
                    e++;
                }
            } else if((rem_a == 0 && rem_b == 1) || (rem_a == 1 && rem_b == 0)) {
                if(c == 1) {
                    int add = 0;
                    ans += add * Math.pow(10, e);
                    e++;
                    c = 1;
                } else {
                    int add = 1;
                    ans += add * Math.pow(10, e);
                    e++;
                }
            } else if(rem_a == 1 && rem_b == 1) {
                if(c == 1) {
                    int add = 1;
                    ans += add * Math.pow(10, e);
                    e++;
                    c = 1;
                } else {
                    int add = 0;
                    ans += add * Math.pow(10, e);
                    e++;
                    c = 1;
                }
            }
            a /= 10;
            b /= 10;
        }
        while(a > 0) {
            rem_a = a % 10;
            if(c == 1) {
                if(rem_a == 0) {
                    int add = 1;
                    ans += add * Math.pow(10, e);
                    e++;
                    c = 0;  
                } else {
                    int add = 0;
                    ans += add * Math.pow(10, e);
                    e++;
                    c = 1;  
                }
            } else {
                if(rem_a == 0) {
                    int add = 0;
                    ans += add * Math.pow(10, e);
                    e++;
                } else {
                    int add = 1;
                    ans += add * Math.pow(10, e);
                    e++;
                }
            }
            a /= 10;
        }

        while(b > 0) {
            rem_b = b % 10;
            if(c == 1) {
                if(rem_b == 0) {
                    int add = 1;
                    ans += add * Math.pow(10, e);
                    e++;
                    c = 0;  
                } else {
                    int add = 0;
                    ans += add * Math.pow(10, e);
                    e++;
                    c = 1;  
                }
            } else {
                if(rem_b == 0) {
                    int add = 0;
                    ans += add * Math.pow(10, e);
                    e++;
                } else {
                    int add = 1;
                    ans += add * Math.pow(10, e);
                    e++;
                }
            }
            b /= 10;
        }
        if(c == 1) {
            ans += 1*Math.pow(10,e);
        }
        return ans;
    }
    public static int getSum(int a, int b) {
        return decEqui(add(binEqui(a), binEqui(b)));
    }
    public static void main(String args[]) {
        // System.out.println(getSum(6, 2));
        System.out.println(getSum(36, 34));
    }
}
