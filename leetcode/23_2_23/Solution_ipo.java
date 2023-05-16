import java.util.*;
class Solution_ipo {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 0; i < capital.length; i++) {
            p.add(profits[i]);
            c.add(capital[i]);
        }
        int t_cap = w;
        //max capital i can buy
        int m = w;
        while(k > 0) {
            m = t_cap;
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < c.size(); i++) {
                if(c.get(i) <= m) {
                    l.add(i);
                }
            }
            int max = Integer.MIN_VALUE;
            int idx = -1;
            //traverse on list
            for (int i = 0; i < l.size(); i++) {
                if(max < p.get(l.get(i))) {
                    max = p.get(l.get(i));
                    idx = l.get(i);
                }
            }
            t_cap += max;
            p.remove(idx);
            c.remove(idx);
            k--;
        }
        return t_cap;
    }

    public static void main(String args[]) {
        int[] profits = {1, 2, 3};
        int[] capital = {1, 1, 2};
        System.out.println(findMaximizedCapital(1, 0, profits, capital));
    }
}