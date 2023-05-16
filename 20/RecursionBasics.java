import javax.swing.RepaintManager;

public class RecursionBasics {

    //Problem 1
    public static void printInc(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        printInc(n - 1);
        System.out.println(n);
    }

    //Problem 2
    public static void printDec(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDec(n - 1);
    }

    //Problem 3--factorial
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }

    //Problem 3--sum of n natural no.s
    public static int sumN(int n) {
        if(n == 1) {
            return 1;
        }
        int s_1 = sumN(n-1);
        int s = n + s_1;
        return s;
    }

    //Problem 5--fibonacci of nth
    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    //Problem 6 --check an array is ascending(sorted)
    public static boolean isSorted(int[] arr, int i) {
        if(i == arr.length-1) {
            return true;
        }
        if(arr[i] < arr[i + 1]) {
            return isSorted(arr, i + 1);
        }
        return false;

        //myMethod
        /*if(i == arr.length - 2) {
            if(arr[i] < arr[i + 1]) {
                return true;
            }
            return false;
        }
        boolean sorted = arr[i] < arr[i + 1];
        if(sorted) {
            return isSorted(arr, i + 1);
        }
        return false;*/
    }

    //Problem 7 --print the first occurence of an element
    public static int firstOccurence(int[] arr, int i, int key) {
        if(i == arr.length) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, i+1, key);
    }

    //Problem 8 --print the last occurence of an element
    public static int lastOccurence(int[] arr, int i, int key) {
        if(i == -1) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }
        return lastOccurence(arr, i-1, key);
    }

    //Problem 9 --print x^n
    public static int power(int x, int n) {
        if(n == 0) {
            return 1;
        }
        return x * power(x, n-1);
    }

    //Problem 10--power fn OPTIMIZED
    public static int powerOptimized(int x, int n) {//O(logn)
        if(n == 0) {
            return 1;
        }
        int halfpow = powerOptimized(x, n/2);
        int halfpowsq = halfpow * halfpow;
        if(n % 2 != 0) {
            return x * halfpowsq;
        }
        return halfpowsq;
    }

    //Problem 11-- Tiling Problem
    public static int tilingProblem(int n) {
        // bases
        if(n == 0 | n == 1) {
            return 1;
        }
        return (tilingProblem(n-1) + tilingProblem(n-2));
    }

    //Problem 12 -- Remove duplicates from string
    public static void removeDuplicates(String str, int idx, StringBuilder sb, boolean[] map) {
        if(idx == str.length()) {
            System.out.println(sb);
            return;
        }
        char currchar = str.charAt(idx);
        if(map[currchar - 'a'] == true) {
            removeDuplicates(str, idx+1, sb, map);
        }
        else {
            map[currchar - 'a'] = true;
            removeDuplicates(str, idx+1, sb.append(currchar), map);
        }
    }

    //myProblem12
    public static String rd(String str, int idx, StringBuilder sb, boolean[] map) {
        if(idx == str.length()) {
            return sb.toString();
        }
        char currchar = str.charAt(idx);
        if(map[currchar - 'a'] != true) {
            map[currchar - 'a'] = true;
            return rd(str, idx+1, sb.append(currchar), map);
        }
        return rd(str, idx+1, sb, map);
    }

    //Problem 13-- Friends Pairing problem
    public static int friendsProblem(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        return (friendsProblem(n-1) + (n - 1) * friendsProblem(n-2));
    }

    //Problem 14-- Binary Strings
    public static void binaryStrings(int n, int lastplace, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }
        binaryStrings(n-1, 0, str +"0");
        if(lastplace == 0) {
            binaryStrings(n-1, 1, str + "1");
        }
    }
    //main fn..
    public static void main(String args[]) {
        // int n = 10;
        // printInc(n);
        // int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        // System.out.println(tilingProblem(0));
//        String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
        // System.out.println(rd(str, 0, new StringBuilder(""), new boolean[26]));

        // System.out.println(friendsProblem(2));
        binaryStrings(3, 0, "");
    }
}