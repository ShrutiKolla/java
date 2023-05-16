public class one
{
    public static float average(int a, int b, int c)
    {
        float avg = (a + b + c)/3.0f; 
        return avg;
    }

    public static boolean isEven(int n)
    {
        if(n % 2 == 0)
            return true;
        else
            return false;
    }

    public static boolean palindrome(int n)
    {
        int rev = 0;
        int num = n;
        while(n > 0)
        {
            rev = rev *10 + (n % 10);
            n /= 10;
        }
        if(rev == num)
            return true;
        else
            return false;
    }

public static int digiSum(int n)
{
    int sum = 0;
    while(n > 0)
    {
        sum += n % 10;
        n /= 10;
    }
    return sum;
}

    public static void main(String args[])
    {
        // System.out.println(average(5,8,3));
        // System.out.println(isEven(7));
        // System.out.println(palindrome(1211));
        System.out.println(digiSum(134));
    }
}
