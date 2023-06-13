import java.util.*;

public class Questions {

    // 1. majority element
    public static void majorityElemenet(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer key : map.keySet()) {
            if(map.get(key) > (nums.length / 3)) {
                System.out.print(key + " ");
            }
        }System.out.println();
    }

    // 2. valid anagrams
    public static Boolean validAnagrams(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);    
        }

        for (int i = 0; i < t.length(); i++) {
            Character key = t.charAt(i);
            if(map.containsKey(key)) {
                if(map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
            } else {
                return false;
            }
        }
        
        return map.isEmpty();
    }

    // 3. count distinct elements
    public static int distinctElements(int[] num) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        return set.size();
    }

    // 4. union and intersection
    public static void unionAndIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> union = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            union.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            union.add(arr2[i]);
        }
        System.out.println(union.size() + " (" + union + ") ");

        // HashSet<Integer> intersection = new HashSet<>();
        // HashSet<Integer> arr = new HashSet<>();
        union.clear();
        for (int i = 0; i < arr1.length; i++) {
            union.add(arr1[i]);
            // arr.add(arr1[i]);
        }
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            // if(arr.contains(arr2[i])) {
            //     intersection.add(arr2[i]);
            // }
            if(union.contains(arr2[i])) {
                count++;
                union.remove(arr2[i]);
            }
        }
        // System.out.println(intersection.size() + " (" + intersection + ") ");
        System.out.println(count);
    }

    // 5. find itinerary from tickets
    public static void itinerary(HashMap<String, String> tickets) {
        String start = startingPoint(tickets);
        while(start != null) {
            System.out.print(start + " --> ");
            start = tickets.get(start);
        }

        System.out.println("destination");
    }
    public static String startingPoint(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for(String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        };
        for(String k : tickets.keySet()) {
            if(!revMap.containsKey(k)) {
                return k;
            }
        }
        return null;
    }

    // 6. largest subarray sum is 0
    public static void LargestSubarray0(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum)) {
                len =Math.max(len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        System.out.println("largest: " + len);
    }
    // subarray sum = k
    public static void subarrSumK(Integer arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // (sum, count)
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == k) {
                if(map.containsKey(sum)) {

                }
            }            
        }
    }
    public static void main(String[] args) {
        //6. Largest subarray sum is 0
        // int arr[] = {15, -2, 2, -8, 1, 7, 10};
        int arr[] = {3,4,5};
        LargestSubarray0(arr); 

        // 5. find itinerary from tickets
        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengaluru"); 
        // tickets.put("Mumbai", "Delhi"); 
        // tickets.put("Goa", "Chennai"); 
        // tickets.put("Delhi", "Goa"); 
        // itinerary(tickets);

        // 4. union and intersection
        // int arr1[] = {7,3,9};
        // int arr2[] = {6,3,9,2,9,4};
        // unionAndIntersection(arr1, arr2);

        // 3. count distinct elements
        // int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        // System.out.println(distinctElements(num));

        // 2. valid anagrams
        // String s = "keen";
        // String t = "knee";
        // System.out.println(validAnagrams(s, t));

        // 1. majority element
        // int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        // int nums[] = {1, 2};
        // majorityElemenet(nums);
    }    
}
