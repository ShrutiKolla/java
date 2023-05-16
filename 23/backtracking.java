public class backtracking {

    public static void changeArr(int[] arr, int i, int val) {
        //base
        if(i == arr.length) {
            printArr(arr);
            return;
        }
        //recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] -= 2;
    }

    public static void printSubsets(String str, String ans, int i) {
        //base
        if(i == str.length()) {
            if(ans.length() == 0) {
                System.out.println("null");
            }
            else {
                System.out.println(ans);
            }
            return;
        }

        //recursion
        //yes
        printSubsets(str, ans + str.charAt(i), i + 1);
        //no
        printSubsets(str, ans, i + 1);
    }

    public static void permutations(String str, String ans) {
        //base
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //recursion
        for(int i = 0 ; i < str.length() ; i++) {
            char currChar = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i+1);
            permutations(newstr, ans + currChar);
        }
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");            
        }
        System.out.println();
    }
    public static void main(String args[]) {
        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        String str = "abc";
        // printSubsets(str, "", 0);
        permutations(str, "");
    }
}