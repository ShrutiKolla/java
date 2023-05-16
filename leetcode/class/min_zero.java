public class min_zero {
    public static void findSum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i == j) {
                    j++;
                }
            }
        }
    } 
    public static void main(String args[]) {
        int[] arr = {1, 60, -10, 70, -80, 85};
    }
}