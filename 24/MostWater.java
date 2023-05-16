import java.util.*;
public class MostWater {

    public static void storeWater(ArrayList<Integer> h) { // O(n^2)
        // select all pairs
        // calc water stored in each pair
        // calc max
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h.size(); i++) {
            for (int j = i+1; j < h.size(); j++) {
                int height = Math.min(h.get(i), h.get(j));
                int width = j - i;
                int area = height * width;
                max = Math.max(area, max);
            }
        }
        System.out.println(max);

    }

    public static void OstoreWater(ArrayList<Integer> h) { // O(n)
        //lp and rp
        //loop until lp < rp
        int lp = 0; int rp = h.size() - 1;
        int max = Integer.MIN_VALUE;
        while(lp < rp) {
            int width = rp - lp;
            int height = Math.min(h.get(rp), h.get(lp));
            int area = width * height;
            max = Math.max(max, area);
            if(h.get(rp) < h.get(lp)) {
                rp--;
            } else {
                lp++;
            }
        }
        System.out.println(max);
    }

    public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        OstoreWater(height);
    }
}
