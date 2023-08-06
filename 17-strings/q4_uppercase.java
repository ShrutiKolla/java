public class q4_uppercase 
{
    public static void upperCase(String str)
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) 
        {
            sb.append(str.charAt(i));
            if(str.charAt(i) == ' ' && i < str.length() - 1)
            {
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
        }
        System.out.println(sb);
    }
    public static void main(String args[])    
    {
        String str = "hi im a cat ";
        upperCase(str);
    }
}
