public class sortedMatSearch
{

//staircase searching using (0, m - 1) cell
    public static void searchMat1(int mat[][], int key)
    {
        int n = mat.length;
        int m = mat[0].length;
        int i = 0, j = m - 1;
        while(i < n && j >= 0)
        {
            int cell = mat[i][j];
            if(key == mat[i][j])
            {
                System.out.println(key + " is at pos: " + "(" + i + "," + j +")");
                return;
            }
            else if(key > cell)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
    }

//staircase search using (n - 1, 0) cell  
    public static void searchMat2(int mat[][], int key)
    {
        int n = mat.length;
        int m = mat[0].length;
        int i = n-1, j = 0;
        while(i >=0 && j < m)
        {
            int cell = mat[i][j];
            if(key == cell)
            {
                System.out.println(key + " is at pos: " + "(" + i + "," + j +")");
                return;
            }
            else if(key > cell)
            {
                j++;
            }
            else
            {
                i--;
            }
        }
    }
//main fn 
    public static void main(String args[])
    {
        int mat[][] = {{10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {27, 29, 37, 48},
                        {32, 33, 39, 50}};

        searchMat2(mat, 33);  
    }
}