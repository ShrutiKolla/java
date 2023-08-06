public class q3_countSetBits 
{

    public static void countSetBits(int n)
    {
        int c = 0;
        while(n > 0)
        {
            if((n & 1) == 1)
            {
                c++;
            }
            n = n>>1;
        }
        System.out.println("count: " + c);
    }

    public static void main(String args[])
    {
        countSetBits(7);
    }
}
