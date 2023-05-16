import java.util.*;
public class one
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a:");        
        int a = sc.nextInt();
        if(a >= 0){
            System.out.println("positive");
        }
        else{
            System.out.println("negative");
        }
    }
}