import java.util.*;
public class three
{
    public static void main(String args[])
    {
        System.out.println("enter week no.(1 - 7)");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch(a)
        {
            case 1: System.out.println("monday");
                    break;
            case 2: System.out.println("tuesday");
                    break;
            case 3: System.out.println("wednesday");
                    break;
            case 4: System.out.println("thursday");
                    break;
            case 5: System.out.println("friday");
                    break;
            case 6: System.out.println("saturday");
                    break;
            case 7: System.out.println("sunday");
                    break;
            default:System.out.println("error");
        }
    }
}