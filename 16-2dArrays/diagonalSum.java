public class diagonalSum
{
    //diagonal sum using bf
    public static void sumBf(int mat[][])
    {
        int n = mat.length;
        int m = mat[0].length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++)
        {
            for (int j = 0; j < m; j++) 
            {
                if(i == j)
                    sum += mat[i][j];//pds
                else if(i + j == n - 1)
                    sum += mat[i][j];//pds
            }
            if(n % 2 != 0)
                sum -= mat[n/2][n/2];
        }
        System.out.println("sum: " + sum);
    }

    //diagonal sum using optimized sol
    public static void sum(int mat[][])
    {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            //pds
            sum += mat[i][i];
            //
            if(i != mat.length-1-i)
                sum += mat[i][mat.length-1-i];
        }
        System.out.println("sum: " + sum);
    }
    
    //main fn...
    public static void main(String args[])
    {
        int mat[][] = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                        };
        sum(mat);
    }
}