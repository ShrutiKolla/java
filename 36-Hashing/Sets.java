import java.util.*;
public class Sets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(3);
        set.add(6);
        set.add(1);
        set.add(4);
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

        // linked hash set

        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(1);
        lhs.add(4);
        lhs.add(2);
        lhs.add(5);
        System.out.println(lhs);

        // tree set

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(4);
        ts.add(3);
        ts.add(8);
        ts.add(1);
        System.out.println(ts);
    }
}
