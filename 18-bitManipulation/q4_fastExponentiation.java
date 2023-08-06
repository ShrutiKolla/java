public class q4_fastExponentiation 
{
    
    public static void fastExponentiation(int n, int i)// 3 5
    {
        // int c = 0;// powers of 2
        // int ans = 1;
        // while(i != 0)
        // {
        //     if((i & 1) == 1)
        //     {
        //         ans *= Math.pow(n, 1 << c);
        //     }
        //     c++;
        //     i = i >>1;
        // }
        // System.out.println(ans);

        int ans = 1;
        while(i > 0)
        {
            if((i & 1) != 0)
            {
                ans *= n;
            }
            n = n*n;
            i = i >> 1;
        }
        System.out.println(ans);
    }

    public static void main(String args[])
    {
        fastExponentiation(5, 3);
    }
}
