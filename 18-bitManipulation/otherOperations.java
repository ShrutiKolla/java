public class otherOperations 
{

    //get ith bit
    public static void getI(int n, int i)
    {
        int bitmask = 1 << i;
        if((n & bitmask) == 0)
            System.out.println(0);
        else
            System.out.println(1);
    }

    //set ith bit
    public static void setI(int n, int i)
    {
        int bitmask = 1 << i;
        System.out.println(n | bitmask);
    }

    //clear ith bit
    public static void clearI(int n, int i)
    {
        int bitmask = 1 << i;
        System.out.println(n & ~bitmask);
    }

    //update ith bit
    public static void updateI(int n, int i, int a)
    {
        // if(a == 0)
        // {
        //     clearI(n, i);
        // }
        // else
        // {
        //     setI(n, i);
        // }

        // clear the ith bit..
        int bitmask = 1 << i;
        n = n & ~bitmask;
        System.out.println(n | a << i);
    }

    //clear last i bits
    public static void clearLastI(int n, int i)
    {
        int bitmask = ~0 << i;
        System.out.println(n & bitmask);
    }

    //claer bits in a range
    public static void clearRange(int n, int i, int j)
    {
        int bitmaskj = ~0 << (j+1);
        // int bitmaski = ~(~0 << i);
        int bitmaski = (1<<i) - 1;
        int bitmask = bitmaski | bitmaskj ;
        System.out.println(n & bitmask);
    }
    //main fn..
    public static void main(String args[])
    {
        clearRange(10, 2, 4);
    }
}
