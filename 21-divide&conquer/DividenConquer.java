public class DividenConquer {

//1--Merge sort
    public static void mergeSort(int[] arr, int si, int ei) {
        //base
        if(si >= ei) {
            return;
        }
        //kaam
        int mid = si + (ei - si)/2; // (si + ei)/2
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    //merge fn...
    public static void merge(int[] arr, int si, int mid, int ei) {
        //left --(0, 3) = 4 ..right--(4, 6) = 3 ..(ei-si+1) = 7
        int temp[] = new int[ei - si + 1];

        int i = si; //left part iterator
        int j = mid + 1; //right part iterator
        int k = 0; //temp iterator

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        //copy temp ele to arr
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

//2-- Quick sort
    public static void quickSort(int[] arr, int si, int ei) {
        if(si >= ei) {
            return;
        }
        int pidx = partition(arr, si, ei);
        quickSort(arr, si, pidx - 1);
        quickSort(arr, pidx + 1, ei);
    }
    //partition fn
    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // --> to create space for ele smaller than pivot!!
        for (int j = si; j < ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                //swap i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap i and pivot
        i++;
        int temp = arr[i];
        arr[i] = arr[ei];//pivot
        arr[ei] = temp;
        return i;
    }

//3-- Sorted and rotated array search
    public static int search(int[] arr, int tar, int si, int ei) {
        //base
        if(si > ei)  {
            return -1;
        }

        //kaam
        int mid = si + (ei - si)/2;
        if(arr[mid] == tar) {
            return mid;
        }
        //mid on L1:
        if(arr[si] <= arr[mid]) {
            //case a: left of L1
            if(arr[si] <= tar  && tar <= arr[mid]) {
                return search(arr, tar, si, mid-1);
            }
            //case b: right of L1
            else {
                return search(arr, tar, mid + 1, ei);
            }
        }
        //mid on L2:
        else {
            //case c: right of L2
            if(arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            }
            //case d : left of L2
            else {
                return search(arr, tar, si, mid - 1);
            }
        }
    }

//HW -- do the 3rd ques using iteration
    public static int iterSearch(int[] arr, int tar) {
        int si = 0;
        int ei = arr.length-1;
        while(si <= ei) {
            int mid = si + (ei-si)/2;
            if(arr[mid] == tar) {
                return mid;
            }
            //case 1:on L1
            else if(arr[si] <= arr[mid]) {
                //case a:
                if(arr[si] <= tar && tar <= arr[mid]) {
                    ei = mid - 1;
                }
                else {
                    si = mid + 1;
                }
            }
            //case 2:on L2
            else {
                if(arr[mid] <= tar && tar <= arr[ei]) {
                    si = mid + 1;
                }
                else {
                    ei = mid - 1;
                }
            }
        }
        return -1;
    }
    //print arr
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //main fn...
    public static void main(String args[]) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(iterSearch(arr, 0));
    }
}