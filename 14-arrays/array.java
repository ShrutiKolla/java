import java.util.*;
public class array{
    public static int getLargest(int arr[])
    {
        int largest = Integer.MIN_VALUE;
        for(int i = 0 ; i <arr.length ; i++)
        {
            if(arr[i] > largest)
                largest = arr[i];
        }
        return largest;
    }
    public static int getSmallest(int arr[])
    {
        int smallest = Integer.MAX_VALUE;
        for(int i = 0 ; i <arr.length ; i++)
        {
            if(arr[i] < smallest)
                smallest = arr[i];
        }
        return smallest;
    }

    public static int BinarySearch(int arr[] , int key)
    {
        int start = 0; int end = arr.length - 1;
        while(start <= end)
        {
            int mid = (start + end)/2;
            if(key == arr[mid])
                return mid;
            else if(key > arr[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void inc(int arr[])
    {
        for(int i = 0 ; i < arr.length ; i++)
        {
            arr[i] += 1;
        }
    }

    public static void rev(int arr[])
    {
        int i = 0, j = arr.length - 1;
        while(i < j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }

//pairs
    public static void pair(int arr[])
    {
        int c = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            int curr = arr[i];
            for(int j = i + 1 ; j < arr.length ; j++)
            {
                System.out.print("(" + curr + " " + arr[j] + ") ");
                c++;
            }
            System.out.println();
        }
        System.out.print("count : " + c);
    }

//subarrays..
    public static void subArrays(int arr[])
    {
        int c = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            int start = i;
            for(int j = i ; j < arr.length ; j++)
            {
                int end = j;
                for(int k = start ; k <= end ; k++)
                {
                    System.out.print(arr[k] + " ");
                }
                c++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("count : " + c);
    }

//min subarray sum
    public static int min_subarr(int arr[])
    {
        int len = arr.length;
        int size = len *(len + 1)/2;
        int sum[] = new int[size];
        int in = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            int start = i;
            for(int j = i ; j < arr.length ; j++)
            {
                int end = j;
                int s = 0;
                for(int k = start ; k <= end ; k++)
                {
                    s += arr[k];
                }
                sum[in] = s;
                in++;
            }
        }
        // for(int i = 0 ; i < sum.length ; i++)
        // {
        //     System.out.print(sum[i] + " ");
        // }
        int min_sum = getLargest(sum);
        return min_sum;
    }


// max subarray sum using BRUTE FORCE
public static int bruteForce(int arr[])
{
    int max_sum = Integer.MIN_VALUE;
    for(int i = 0 ; i < arr.length ; i++)
    {
        int start = i;
        for(int j = i ; j < arr.length ; j++)
        {
            int end = j;
            int currsum = 0;
            for(int k = start ; k <= end ; k++)
            {
                currsum += arr[k];
            }
            System.out.print(currsum + " ");
            if(currsum > max_sum)
                max_sum = currsum;
        }
            System.out.println();
    }
    return max_sum;
}

// max subarray sum using PREFIX SUM
public static int prefixSum(int arr[])
{
    int prefix[] = new int[arr.length];
    prefix[0] = arr[0];
    int max_sum = Integer.MIN_VALUE;

    for(int i = 1 ; i < arr.length ; i++)
    {
        prefix[i] = arr[i] + prefix[i-1];
    }

    for(int i = 0 ; i < arr.length ; i++)
    {
        int start = i;
        for(int j = i ; j < arr.length ; j++)
        {
            int end = j;
            int currsum = 0;
            currsum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
            System.out.print(currsum + " ");
            if(currsum > max_sum)
                max_sum = currsum;
        }
            System.out.println();
    }
    return max_sum;
}

// max subarray sum using KADANE'S ALGO
public static int kadane(int arr[])
{
    int currsum = 0;
    int max_sum = Integer.MIN_VALUE;
    int all_neg = 1;
    for(int i = 0 ; i < arr.length ; i++)
    {
        if(arr[i] > 0)
            all_neg = 0;
    }
    if(all_neg == 1)
    {
        max_sum = getLargest(arr);
        return max_sum;
    }
    for(int i = 0 ; i < arr.length ; i++)
    {
        currsum += arr[i];
        if(currsum < 0)
            currsum = 0;
        max_sum = Math.max(max_sum, currsum);
    }
    return max_sum;
}
//main fn..
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        // int arr[] = {-2, -3, 3, -1, -6};
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        // for(int i = 0 ; i < arr.length ; i++){
        //     arr[i] = sc.nextInt();
        // }
        // for(int i = 0; i < arr.length ; i++)
        // {
        //     System.out.println(arr[i]);
        // }
        // subArrays(arr);
        System.out.print("\nmax sum: " + kadane(arr));
    }
}