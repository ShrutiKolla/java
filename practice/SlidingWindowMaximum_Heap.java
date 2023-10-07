import java.util.*;

public class SlidingWindowMaximum_Heap {
    static class Window implements Comparable<Window> {
        int idx;
        int val;

        public Window(int i, int v) {
            idx = i;
            val = v;
        }

        @Override
        public int compareTo(Window a) {
            if(this.val == a.val) {
                return 0;
            }
            return this.val < a.val ? 1 : -1; 
        }
        public String toString() {
            return this.val + " ";
        }
    }
    public static void windowMax(int[] arr, int k) {
        int n = arr.length;
        int max[] = new int[n - k + 1];
        PriorityQueue<Window> pq = new PriorityQueue<>();
        if(n >= 3) {
            pq.add(new Window(0, arr[0]));
            pq.add(new Window(1, arr[1]));
            pq.add(new Window(2, arr[2]));
        }
        int idx=0;
        max[idx++] = pq.peek().val;

        for(int i = 3; i < n ; i++) {
            pq.add(new Window(i, arr[i]));
            Window curr = pq.peek();
            if(curr.idx <= i - k) {
                pq.remove();
            } else {
                max[idx++] = curr.val;
            }
        }
        for (int i = 0; i < max.length; i++) {
            System.out.print(max[i] + " ");
        }System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        windowMax(arr, 3);
    }
}
