public class assgn_2
{
    //swap two no.s..
    public static void swap(int x, int y)
    {
        x = x^y;
        y = x^y;
        x = x^y;
        System.out.println("x: " + x + " y: " + y);
    }

    public static void main(String args[])
    {
        swap(5,9);
    }
}
