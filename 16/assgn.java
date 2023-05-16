public class assgn
{
    //1st question..
    public static void one(int array[][])
    {
        int c = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if( array[i][j] == 7)
                    c++;
            }
        }
        System.out.println("count of 7 : " + c);
    }

    //2nd question..
    public static void two(int[][] nums)
    {
        int sum = 0;
        for (int i = 0; i < nums[0].length; i++) 
        {
            sum += nums[1][i];
        }
        System.out.println("sum : " + sum);
    }

    //3rd question..
    public static void three(int[][] nums)
    {
        for (int i = 0; i < nums.length; i++) 
        {
            for (int j = i + 1; j < nums[0].length; j++) 
            {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp; 
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
    //main fn..    
    public static void main(String args[])
    {
        int[][] array = {{4, 7, 8}, {8, 8, 7}};
        //one(array);
        int [][] nums = {{1, 4, 9}, 
                        {11, 4, 3},   
                        {2, 2, 3}};
        //two(nums);
        three(nums);
    }
}
