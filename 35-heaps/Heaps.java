import java.util.*;
public class Heaps {
    public static class heap {
        ArrayList<Integer> AL = new ArrayList<>();
        public void insert(int data) {
            // add at the end
            AL.add(data);

            // fix
            int curr = (AL.size() - 1);
            int par = (curr - 1) / 2;

            while(AL.get(curr) < AL.get(par)) {
                //swap
                int temp = AL.get(curr);
                AL.set(curr, AL.get(par));
                AL.set(par, temp);
                curr = par;
                par = (curr - 1) / 2;
            }
        }
        public void print() {
            for (int i = 0; i < AL.size(); i++) {
                System.out.print(AL.get(i) + " ");
            }
        }
    }

    public static void main(String[] args) {
        heap h1 = new heap();
        h1.insert(2);
        h1.insert(3);
        h1.insert(4);
        h1.insert(5);
        h1.insert(10);
        h1.insert(1);
        h1.print();
    }
}
