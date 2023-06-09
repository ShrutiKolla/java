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
    public static void main(String[] args) {
        // 2. valid anagrams
        String s = "keen";
        String t = "knee";
        System.out.println(validAnagrams(s, t));
        // 1. majority element
        // int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        // int nums[] = {1, 2};
        // majorityElemenet(nums);
    }    
}
