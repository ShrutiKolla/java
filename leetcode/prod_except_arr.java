
public class prod_except_arr {
    public static void printarr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static int[] productExceptSelf(int[] nums) {
        int prod = 1;
        for(int i = 0 ; i < nums.length ; i++) {
            prod *= nums[i];
        }
        int[] answer = new int[nums.length];
        for(int i = 0 ; i < answer.length ; i++) {
            if(nums[i] == 0) {
                System.out.println("its 0: " + nums[i] + " " + i);
                int p = 1;
                for(int j = 0 ; j < answer.length ; j++) {
                    if(j == i) {
                        continue;
                    }
                    System.out.println(p + " " + nums[j]);
                    p *= nums[j];
                }
                answer[i] = p;
            }
            else {
                answer[i] = prod / nums[i];
            }
        }
        return answer;
    }
    public static void main(String args[]) {
        int nums[] = {-1,1,0,-3,3};
        printarr(productExceptSelf(nums));
    }
}
