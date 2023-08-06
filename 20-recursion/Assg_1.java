public class Assg_1 {

    static String digits[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    //Assng-1 -- print all occurences of key
    public static void allOccurene(int arr[], int i, int key) {// 3, 2, 4, 5, 6, 2, 7, 2, 2
        if(i == arr.length) {//                                   0  1  2  3  4  5  6  7  8
            return;
        }
        if(arr[i] == key) {
            System.out.print(i + " ");
        }
        else {
            allOccurene(arr, i+1, key);
        }
    }

    //Assgn-2 -- given no. to english string
    public static void numToEng(int n) {
        if(n == 0) {
            return;
        }
        int ld = n % 10;    
        numToEng(n/10);
        System.out.print(digits[ld] + " ");
    }

    //Assgn-3 -- length of a string
    public static int len(String str) {
        if(str.length() == 0) {
            return 0;
        }
        return 1 + len(str.substring(1));
    }

    //Assgn-4 -- hanoi's tower
    public static void hanoi(int n, String src, String helper, String dest) {
        if(n == 1) {
            System.out.println("transfer disc " + n + " from " + src + " to " + dest);
            return;
        }
        hanoi(n-1, src, dest, helper);
        System.out.println("transfer disc " + n + " from " + src + " to " + dest);
        hanoi(n-1, helper, src, dest);
    }
    public static void main(String args[]) {
        // int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        // allOccurene(arr, 0, 2);
        // numToEng(2019);
        hanoi(3, "A", "B", "C");
    }
}
