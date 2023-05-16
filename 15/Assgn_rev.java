public class Assgn_rev {

    //1--Bubble sort
    public static void bubbleSort(int[] arr) {
        for (int turn = 0; turn < arr.length-1; turn++) {
            for (int j = 0; j < arr.length-1-turn; j++) {
                if(arr[j] < arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    //2--Selection sort
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[minPos]) {
                    minPos = j;
                }
            }
            //swap
            int t = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = t;
        }
    }

    //3--Insertion sort
    public static void insertionSort(int[] arr) {
        //unsorted
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while(prev >= 0 && arr[prev] < curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }
    //Count sort
    public static void countSort(int[] arr) {
        //find largest in arr
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        
        //create count --> freq array
        int[] count = new int[largest + 1];

        //fill count array
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        //sort
        int j = 0;
        for (int i = count.length-1; i >= 0; i--) {
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
        // Integer arr[] = {5, 1, 3, 2, 4};
        // Arrays.sort(arr, Collections.reverseOrder());
        insertionSort(arr);
        printArr(arr);
    }
}