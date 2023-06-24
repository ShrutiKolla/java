public class FloodFillCode {

    public static void helper(int[][] image, int sr, int sc, int color, int ogCol, boolean vis[][]) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length ||
            vis[sr][sc] || image[sr][sc] != ogCol) {
                return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;
        // left
        helper(image, sr, sc-1, color, ogCol, vis);
        // right
        helper(image, sr, sc+1, color, ogCol, vis);
        // up
        helper(image, sr-1, sc, color, ogCol, vis);
        // down
        helper(image, sr+1, sc, color, ogCol, vis);

    }
    public static void floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        int ogCol = image[sr][sc];
        helper(image, sr, sc, color, ogCol, vis);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;

        floodFill(image, sr, sc, color);
    }
}
