import java.util.*;
public class conversion
{
    public static int binToDec(int n)
    {
        int pow = 0;
        int dec = 0;
        while(n > 0)
        {
            dec += (n % 10) * Math.pow(2, pow);
            pow++;;
            n/= 10;
        }
        return dec;
    }

    public static int decTobin(int n)
    {
        // int mul = 1;
        // int bin = 0;
        // while(n >= 1)
        // {
        //     bin += (n % 2)* mul;
        //     mul *= 10;
        //     n /= 2;
        // }
        // return bin;

        int rem = 0;
        int pow = 0;
        int bin = 0;
        while(n > 0)
        {
            rem = n % 2;
            bin += rem * Math.pow(10, pow);
            pow++;
            n /= 2;
        }
        return bin;
    }
    public static void main(String args[])
    {
        System.out.println(binToDec(1000));
        System.out.println(decTobin(6));
    }
}