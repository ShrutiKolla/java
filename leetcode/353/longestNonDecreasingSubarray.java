public class longestNonDecreasingSubarray {
    public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] nums3 = new int[n];
        
        int count = 1;
        
        nums3[0] = Math.min(nums1[0], nums2[0]);
        for(int i = 1; i < n ; i++) {
            System.out.println(nums1[i] + " " + nums2[i] + " " + i + " " + n);
            int val = Math.min(nums1[i], nums2[i]);
            System.out.println(val);
            if(val >= nums3[i-1]) {
                nums3[i] = val;
                count++;
                System.out.println(nums3[i-1] +" " + count);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,3,2,1};
        int[] nums2 = {2,2,3,4};
        System.out.println(maxNonDecreasingLength(nums1, nums2));
    }
}