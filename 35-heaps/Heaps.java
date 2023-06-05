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

        PriorityQueue<Ropes> PQ = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            PQ.add(new Ropes(ropes[i]));
        }

        while(PQ.size() > 1) {
            int sum = PQ.remove().rlen + PQ.remove().rlen;
            PQ.add(new Ropes(sum));
            cost += sum;
        }
        System.out.println("total cost : " + cost);
    }

    public static void main(String[] args) {

        // 3.
        int ropes[] = {2,3,4,6};
        connectNropes(ropes);

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
