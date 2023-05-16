import java.util.ArrayList;

public class expt {
    public static void main(String args[]) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(0);
        l.add(8);
        l.add(9);
        l.add(3);
        l.add(4);
        System.out.println(l);
        l.remove(2);
        System.out.println(l);
    }
}
