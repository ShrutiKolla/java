import java.util.*;
public class three
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int fact = 1;
        int n = sc.nextInt();
        if(n == 1 || n == 0)
            System.out.println("factorial of " + n + ": " + fact);
        else
        {
            for(int i = 1 ; i <= n ; i++)
            {
                fact *= i;
            }
            System.out.println("factorial of " + n + ": " + fact);
        }
    }
}