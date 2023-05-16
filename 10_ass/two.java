import java.util.*;
public class two
{
    public static void main(String args[])
    {
        int evensum = 0;
        int oddsum = 0;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("enter no.:");
            int d = sc.nextInt();
            if(d % 2 == 0)
                evensum += d;
            else
                oddsum += d;
            i++;
        }while(i < 10);
            
        System.out.println("even = " + evensum);
        System.out.println("odd = " + oddsum);
    }
}