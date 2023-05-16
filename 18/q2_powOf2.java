public class q2_powOf2 
{
    
    public static void powOf2(int n)
    {
        if((n & (n - 1)) == 0)
        {
            System.out.println(n + "yes");
        }
        else
        {
            System.out.println(n + "no");
        }
    }

    public static void main(String args[])
    {
        for (int i = 0; i <= 64; i++) {
            powOf2(i);
        }
    }
}
