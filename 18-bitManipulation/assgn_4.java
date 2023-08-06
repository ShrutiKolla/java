public class assgn_4 
{

    public static void ucTolc(String s)
    {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) 
        {
            sb.append((char)(s.charAt(i) | ' '));
        }
        sb.toString();
        System.out.println(sb);
    }

    public static void main(String args[])
    {
        ucTolc("SHRUTI");
    }
}
