import java.util.ArrayList;
public class TargetSum2 {
    public static Boolean tSum(ArrayList<Integer> list, int t) {
        //calc pivot pt
        //2 pointer
        int lp = 0;
        int rp = list.size() -1;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > list.get(i + 1)) {
                rp = i;
                lp = i + 1;
                break;
            }
        }

        while(lp != rp) {
            if(list.get(lp) + list.get(rp) == t) {
                System.out.println(list.get(rp) + " " + list.get(lp));
                return true;
            } else if(list.get(lp) + list.get(rp) < t) {
                lp = (lp + 1) % list.size();
            } else {
                rp = (list.size() + rp - 1) % list.size();
            }
        }
        return false;
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(tSum(list, 16));
    }
}
