public class inverted_star
{
    public static void main(String args[])
    {
        int n = 4;
        for(int i = 0; i < n ; i++)
        {
            for(int j = 0 ; j < n - i ; j++)// for(int j = n ; j > i ; j--)
            {                               // {
                System.out.print("* ");      //     System.out.print("* ");
            }                               // }
            System.out.println();
        }
    }
}