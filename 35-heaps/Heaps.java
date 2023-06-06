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

        public int peek() {
            return AL.get(0);
        }

        public void delete() {
            // swap 1st and last
            int temp = AL.get(AL.size() - 1);
            AL.set(AL.size() - 1, AL.get(0));
            AL.set(0, temp);

            // delete last
            AL.remove(AL.size() - 1);

            // heapify
            heapify(0);
        }

        private void heapify(int idx) {
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int minIdx = idx;

            if(left < AL.size() && AL.get(minIdx) > AL.get(left)) {
                minIdx = left;
            }

            if(right < AL.size() && AL.get(minIdx) > AL.get(right)) {
                minIdx = right;
            }

            if(minIdx != idx) {
                // swap
                int temp = AL.get(minIdx);
                AL.set(minIdx, AL.get(idx));
                AL.set(idx, temp);
                heapify(minIdx);
            }
        }

        // 1. heap sort

        private void Heapify(int idx, int size, int[] arr) {
            int left = idx * 2 + 1;
            int right = idx * 2 + 2;
            int maxIdx = idx;

            if(left < size && arr[maxIdx] < arr[left]) {
                maxIdx = left;
            }

            if(right < size && arr[maxIdx] < arr[right]) {
                maxIdx = right;
            }

            if(maxIdx != idx) {
                // swap
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[0];
                arr[0] = temp;
                Heapify(maxIdx, size, arr);
            }
        }
        public void heapSort(int[] arr) {
            // arr -> maxHeap
            int n = arr.length;
            for (int i = n/2; i >= 0; i--) {
                Heapify(i, n, arr);
            }

            /*
                2. 
                    swap(0,i)
                    heapify(0,i)
            */ 

            for (int i = n - 1; i >= 0; i--) {
                // swap
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
                Heapify(0, i, arr);
            }
        }
        
        
        public void print() {
            for (int i = 0; i < AL.size(); i++) {
                System.out.print(AL.get(i) + " ");
            }
        }
    }

    // 2. Nearest k cars

    static class Dist implements Comparable<Dist>{
        int x, y;
        String name;
        int distSq;

        Dist(int i, int x, int y) {
            this.name = "C" + i;
            this.x = x;
            this.y = y;
            distSq = (int)Math.pow(x, 2) + (int)Math.pow(y, 2);
        }
        @Override
        public int compareTo(Dist o) {
            if(this.distSq == o.distSq) {
                return 0;
            }

            return this.distSq < o.distSq ? -1 : 1;
        }

        @Override
        public String toString() {
            return name + ": " + Math.sqrt(distSq) + " cm sq. ";
        }

    }
    public static void nearestKcars(int cars[][], int k) {
        PriorityQueue<Dist> PQ = new PriorityQueue<>();
        for (int i = 0; i < cars.length; i++) {
            PQ.add(new Dist(i, cars[i][0], cars[i][1]));
        }
        for (int i = 0, a = 1; i < PQ.size() && a <= k; i++, a++) {
            System.out.println(PQ.remove());
        }

    }

    // 3. connect N ropes
    static class Ropes implements Comparable<Ropes>{
        int rlen;
        Ropes(int r) {
            rlen = r;
        }

        public int compareTo(Ropes r) {
            if(this.rlen == r.rlen) {
                return 0;
            }
            return this.rlen < r.rlen ? -1 : 1;
        }
        public String toString() {
            return "len: " + rlen;
        }
    }
    public static void connectNropes(int ropes[]) {
        int cost = 0;

        // PriorityQueue<Ropes> PQ = new PriorityQueue<>();
        PriorityQueue<Integer> PQ = new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++) {
            // PQ.add(new Ropes(ropes[i]));
            PQ.add(ropes[i]);
        }

        while(PQ.size() > 1) {
            // int sum = PQ.remove().rlen + PQ.remove().rlen;
            int sum = PQ.remove() + PQ.remove();
            PQ.add(sum);
            cost += sum;
        }
        System.out.println("total cost : " + cost);
    }

    // 4. weakest soldier
    static class soldier implements Comparable<soldier>{
        int idx;
        int no;

        soldier(int idx, int no) {
            this.idx = idx;
            this.no = no;
        }

        @Override
        public int compareTo(soldier s) {
            if(this.no == s.no) {
                // return this.idx < s.idx ? -1 : 1;
                return this.idx - s.idx;
            }

            // return this.no < s.no ? -1 : 1;
            return this.no - s.no;
        }

        @Override
        public String toString() {
            return "row " + idx + " ";
        }

    }

    public static void weakestSoldier(int sol[][], int k) {

        PriorityQueue<soldier> PQ = new PriorityQueue<>();
        for (int i = 0; i < sol.length; i++) {
            int count = 0;
            for (int j = 0; j < sol[i].length; j++) {
                count += sol[i][j];
            }
            PQ.add(new soldier(i, count));
        }
        for (int i = 0; i < k; i++) {
            System.out.print(PQ.remove());
        }
    }

    // 5. Sliding window max
    static class Window implements Comparable<Window>{
        int idx;
        int el;
        
        Window(int i, int e) {
            idx = i;
            el = e;
        }

        public int compareTo(Window w) {
            if(this.el == w.el) {
                return 0;
            }
            return w.el - this.el;
        }

        public String toString() {
            return this.el + "";
        }
    }
    public static void windowMax(int arr[], int k) {
        int n = arr.length;
        int i = 0;
        int j = 0;

        PriorityQueue<Window> PQ = new PriorityQueue<>();
        int max[] = new int[n - k + 1];
        while(i < k) {
            PQ.add(new Window(i, arr[i]));
            i++;
        }
        max[j] = PQ.peek().el;
        j++;
        while(i < n) {
            while(PQ.peek().idx <= i - k) {
                PQ.remove();
            }
            PQ.add(new  Window(i, arr[i]));
            max[j] = PQ.peek().el;

            j++;i++;
        }
        for (int l = 0; l < max.length; l++) {
            System.out.print(max[l] + " ");
        }
    }

    public static void main(String[] args) {
        // 5.
        // int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        windowMax(arr, k);

        // 4.
        // int sol[][] = {{1,0,0,0},
        //             {1,1,1,1},
        //             {1,0,0,0},
        //             {1,0,0,0}};
        // int k = 2;
        // weakestSoldier(sol, k);

        // 3.
        // int ropes[] = {6,3,2,3,4};
        // connectNropes(ropes);

        // 2. nearest k cars
        // int cars[][] = {{3,3}, {5,-1}, {-2, 4}};
        // nearestKcars(cars, 2);

        // 1. heapSort
        // int arr[] = {1, 2, 4, 5, 3};
        // heap h2 = new heap();
        // h2.heapSort(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        // delete
        // heap h1 = new heap();
        // h1.insert(2);
        // h1.insert(3);
        // h1.insert(4);
        // h1.insert(5);
        // h1.insert(10);
        // h1.insert(1);
        // h1.print();
        // h1.delete();
        // System.out.println();
        // h1.print();


    }
}
