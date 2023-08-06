import java.util.ArrayList;
public class AL {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        list.remove(3);
        list.set(3, 10);
        System.out.println(list);
        
        // System.out.println(list.contains(10));
        // System.out.println(list.contains(11));
        list.add(4, 11);
        System.out.println(list);

    }
}