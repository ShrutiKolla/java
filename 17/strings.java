// import java.util.*;
public class strings
{
    //traversing string using charAt()
    public static void stringCharat( String str)
    {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }

    //main fn..
    public static void main(String args[])
    {
        // 1st fn..
        /*String fn = "Shruti";
        String ln = new String();
        Scanner sc = new Scanner(System.in);
        ln = sc.next();
        String fulln = fn + " " + ln;
        stringCharat(fulln);*/

        

        /*String path = "WNEENESENNN";
        //using substring method..
        System.out.println(path.substring(3, 5));*/

        //using equals method
        /*String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        if(s1 == s2)
            System.out.println("yes");
        else
            System.out.println("no");
        if(s1 == s3)
            System.out.println("yes");
        else
            System.out.println("no");
        System.out.println(s1.equals(s3));*/

    }
}