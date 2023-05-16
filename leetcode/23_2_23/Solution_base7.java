class Solution_base7 {
    public static String convertToBase7(int num) {
        int ans=0;
        int rem=0;
        int e=0;
        int n = num;
        num = Math.abs(num);
        while(num > 0) {
            rem = num % 7;
            ans += rem * Math.pow(10, e);
            e++;
            num /= 7;
        }
        if(n > 0) {
            Integer a = ans;
            System.out.println(a);
            String res = a.toString();
            return res;
        } else {
            Integer a = -ans;
            String res = a.toString();
            return res;
        }
    }
    public static void main(String args[]) {
        System.out.println(convertToBase7(-7));
        // Integer a = -10;
        // System.out.println();
    }
}