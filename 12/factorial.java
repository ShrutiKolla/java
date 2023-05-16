import java.util.*;
public class factorial
{
    public static double fact(int n)
    {
        double f = 1;
        if(n == 0)
            return f;
        else
        {
            for(int i = 1 ; i <= n ; i++)
            {
                f *= i;
            }
            return f;
        }
    }
    public static double bin_coeff(int n , int r)
    {
        double fact_n = fact(n);
        double fact_r = fact(r);
        double fact_nmr = fact(99);
        return (fact_n/(fact_r * fact_nmr));
    }
    public static void main(String args[])
    {
        System.out.println(fact(99));
        System.out.println(bin_coeff(100,1));
    }
}