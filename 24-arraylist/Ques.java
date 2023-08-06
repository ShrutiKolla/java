import java.lang.reflect.Array;
import java.util.*;
public class Ques {

    public static void printRev(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        } System.out.println();
    }

    public static void max(ArrayList<Integer> list) {
        int lar = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            lar = Math.max(lar, list.get(i));
        }
        System.out.println(lar);
    }

    public static void swap(ArrayList<Integer> list, int i1, int i2) {
        int temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }
    public static void main(String args[]) {
        /*ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println(("enter element: "));
            Integer e = sc.nextInt();
            list.add(e);
        }*/

        // printRev(list);
        // max(list);

        // swap(list, 3, 2);

        //sort
        /*Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);*/

        //multidirectional al
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            list1.add(i);
            list2.add(i*2);
            list3.add(i*3);
        }
        main.add(list1);
        main.add(list2);
        main.add(list3);
        System.out.println(main);

        for (int i = 0; i < main.size(); i++) {
            ArrayList<Integer> currList = main.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }System.out.println();
        }
    }
}
