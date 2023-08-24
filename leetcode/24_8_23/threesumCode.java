import java.util.*;

public class threesumCode {
    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<HashSet<Integer>> set = new HashSet<>();
        List<List<Integer>> list= new ArrayList<>();
        int i, j, k;
        int target = 0;
        int n = nums.length - 1;
        Arrays.sort(nums);
        for (k = 0; k <= n; k++) {
            if (k != 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            i = 0;
            j = n;
            while (i < j) {
                if ((i != 0 && nums[i] != nums[i - 1]) || (i == k)) {
                    i++;
                }
                if ((j != n && nums[j] != nums[j + 1]) || (j == k)) {
                    j--;
                }
                int sum = nums[k] + nums[i] + nums[j];
                System.out.println(nums[k] + " " +  nums[i] + " " + nums[j]);
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    HashSet<Integer> temp = new HashSet<>();
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    if (!set.contains(temp)) {
                        set.add(temp);
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[k]);
                        l.add(nums[i]);
                        l.add(nums[j]);
                        list.add(l);
                    }
                    i++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // int[] nums = { -1, 0, 1, 2, -1, -4 };
        int[] nums = { 0,0,0 };
        // threeSum(nums);
        System.out.println(threeSum(nums));
    }
}
