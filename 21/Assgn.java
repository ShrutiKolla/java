import java.sql.Array;

public class Assgn {
    
//1 -- Sort String arr using MERGE SORT
    public static void mergeSort(String arr[], int si, int ei) {
        //base
        if(si >= ei) {
            return;
        }
        //kaam
        int mid = si + (ei - si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }
    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int i = si;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= ei) {
            if(arr[i].compareTo(arr[j]) < 0 ) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//2-- return MAJORITY ELE from nums arr
    public static void majorityElement(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        // count -- freq arr
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] > Math.floor(arr.length/2)) {
                System.out.println(i);
            }
        }
    }

//3-- find INVERSION COUNT
    public static int inversionCount(int arr[]) {
        int swap_c = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int swap = 0;
            for (int j = 0; j < arr.length-1-i; j++) {
                // System.out.prin///tln(i + " " + j + " " + arr[j] + " " + arr[j+1]);
                if(arr[j] > arr[j + 1]) {
                    swap++;
                    // System.out.println(arr[j] + " " + arr[j + 1] + " " + swap);
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    // printArr(arr);
                    swap_c++;
                }
            }
            if(swap == 0) {
                return swap_c;
            }
        }
        return swap_c;
    }
//main fn...
    public static void main(String args[]) {
        // String arr[] = {"sun", "earth", "mars", "mercury"};
        // mergeSort(arr, 0, arr.length-1);
        // printArr(arr);

        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(inversionCount(nums));
    }
}
