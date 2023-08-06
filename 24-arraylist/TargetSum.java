import java.util.ArrayList;

public class TargetSum {

    public static Boolean tSum(ArrayList<Integer> list, int t) {
        int lp = 0;
        int rp = list.size() - 1;
        while(lp != rp) {
            if(list.get(lp) + list.get(rp) == t) {
                System.out.println(lp + " " + rp);
                return true;
            } else if(list.get(lp) + list.get(rp) > t) {
                rp--;
            } else {
                lp++;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 9;
        tSum(list, target);
    }
}
