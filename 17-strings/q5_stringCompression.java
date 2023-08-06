public class q5_stringCompression 
{

    //fn to compress a string
    public static void compress(String str) //O(n)
    {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) 
        {
            char ch = str.charAt(i);
            Integer c = 1;
            while(i < str.length() - 1 && str.charAt(i) == str.charAt(i+1))
            {
                c++;
                i++;
            }
            sb.append(ch);
            if(c > 1)
            {
                sb.append(c.toString());
            }
        }
        System.out.println(sb);
    }    

    //main fn..
    public static void main(String args[])
    {
        String str = "aaaabbbccd";
        compress(str);
    }
}
