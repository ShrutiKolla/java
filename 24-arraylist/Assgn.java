import java.util.ArrayList;
public class Assgn {
    public static boolean monoTonic(ArrayList<Integer> arr) {
        int j = 0;
        while(arr.get(j) == arr.get(j+1)) {
            j++;
        }
        if(arr.get(j) < arr.get(j+1)) {
            for (int i = j + 1; i < arr.size() -1; i++) {
                if(arr.get(i) > arr.get(i + 1)) {
                    return false;
                }
            }
        } else {
            for (int i = j + 1; i < arr.size() -1; i++) {
                if(arr.get(i) < arr.get(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static ArrayList<Integer> Lonely(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        Boolean ans = true;
        for (int i = 0; i < list.size(); i++) {
            int ele = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if(j == i) {
                    continue;
                }
                if((list.get(j) == ele) || (list.get(j) == ele + 1) || (list.get(j) == ele - 1)) {                    
                    ans = false;
                    break;
                }
            }
            if(ans) {
                res.add(list.get(i));
            }
            ans = true;
        }
        return res;
    }

    public static void main(String args[]) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(3);
        System.out.println(Lonely(nums));
    }
}
