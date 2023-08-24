import java.util.*;

public class setExpt {

    public static void main(String[] args) {
        HashSet<HashSet<Integer>> hs = new HashSet<>();
        HashSet<Integer> htemp = new HashSet<>();
        HashSet<Integer> htemp1 = new HashSet<>();
        htemp.add(1);
        htemp.add(2);
        htemp.add(3);
        htemp1.add(3);
        htemp1.add(1);
        htemp1.add(2);
        hs.add(htemp);
        System.out.println(hs.contains(htemp1));
        for(HashSet<Integer> i : hs) {
            for(Integer j : i) {
                System.out.println(j);
            }
        }
    }
}
