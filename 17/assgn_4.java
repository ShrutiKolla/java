public class assgn_4 
{

    //fn to check anagrams..
    public static boolean anagrams(String str1, String str2)
    {
        if(str1.length() == str2.length())
        {
            for (int i = 0; i < str1.length(); i++) 
            {
                Character ch = str1.charAt(i);
                for (int j = 0; j < str2.length(); j++) 
                {
                    if(str2.charAt(j) == ch)
                    {
                        str2 = str2.replace(Character.toString(ch), "");
                        break;
                    }
                }    
                str1 = str1.replace(Character.toString(ch), "");
                i--;
            }
        }
        if(str1 == "" && str2 == "")
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //main fn..
    public static void main(String args[])
    {
        System.out.println(anagrams("race", "care"));
    }
}
