public class assgn_1 
{
    
    //count lowercase vowels
    public static void lowerVowels(String str)
    {
        int c = 0;
        for (int i = 0; i < str.length(); i++) 
        {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
            {
                c++;
            }    
        }
        System.out.println("count: " + c);
    }

    //main fn..
    public static void main(String args[])
    {
        String str = "My name is SHRUTi";
        lowerVowels(str);
    }
}
