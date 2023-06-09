import java.util.*;
public class Sets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(9);
        System.out.println(set);
        // System.out.println(set.size());
        // System.out.println(set.contains(3));
        // System.out.println(set.contains(2));
        System.out.println(set.remove(2));
        System.out.println(set.isEmpty());
        System.out.println(set);

        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("\nUsing advanced for loops");

        for(Integer i : set) {
            System.out.println(i);
        }
    }
}
