public class countNegNosInSortedMatrix {
    class Solution {
        public int countNegatives(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int i = 0;
            int j = m - 1;
            int count = 0;
            while(i < n && j >= 0) {
                int key = grid[i][j];
                if(key < 0) {
                    count += n - i;
                    j--;
                } else {
                    i++;
                }
            }
            return count;
        }
    }
}
