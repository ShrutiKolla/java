import java.util.*;
public class three
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        float pen = sc.nextFloat();
        float pencil = sc.nextFloat();
        float eraser = sc.nextFloat();
        float total = pen + pencil + eraser;
        total += 0.18f*total;
        System.out.print("total bill including gst: " + total);
    }
}