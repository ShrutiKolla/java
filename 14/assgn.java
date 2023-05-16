public class assgn
{
    public static boolean one(int nums[])// 1 2 3 1
    {
        int c[] = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++)
        {
            int a = nums[i];
            for(int j = i+1 ; j < nums.length ; j++)
            {
                if(nums[j] == a)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        int nums[] = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(one(nums));
    }
}