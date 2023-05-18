import java.util.*;
public class classroom {

    // 1. activity selection
    public static ArrayList<Integer> activitySelection(int[] start, int end[]) { // O(nlogn)
        ArrayList<Integer> list = new ArrayList<>();

        // initializing 2 d arr
        int sorted[][] = new int[start.length][3];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i][0] = i;
            sorted[i][1] = start[i];
            sorted[i][2] = end[i];
        }

        // sorting
        Arrays.sort(sorted, Comparator.comparingDouble(o -> o[2]));
        list.add(sorted[0][0]);
        System.out.println(list.get(0));
        int count = 1;
        int lastEnd = sorted[0][2];
        print(sorted);
        for (int i = 1; i < sorted.length; i++) {
            if(sorted[i][1] >= lastEnd) {
                list.add(sorted[i][0]);
                lastEnd = sorted[i][2];
                count++;
            }
        }
        System.out.println("a person can perform " + count + "  activities");
        return list;

        // int k = 0;
        // list.add(0);
        // int count = 1;
        // for (int i = 1; i < end.length; i++) {
        //     if(start[i] >= end[list.get(k)]) {
        //         list.add(i);
        //         k++;
        //         count++;
        //     }
        // }
        // System.out.println("a person can perform " + count + "  activities");
        // return list;
    }

    // 2. fractional knapsack
    public static void knapSack(int[] weight, int[] value, int capacity) { // O(nlogn)
        int sorted[][] = new int[weight.length][2];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i][0] = i;
            sorted[i][1] = value[i]/weight[i];
        }
        Arrays.sort(sorted, Comparator.comparingDouble(o -> o[1]));
        int maxValue = 0;
        for (int i = sorted.length - 1; i >= 0; i--) {
            if(weight[sorted[i][0]] <= capacity) {
                capacity -= weight[sorted[i][0]];
                maxValue += value[sorted[i][0]];
            } else {
                maxValue += (sorted[i][1] * capacity);
                break;
            }
        }
        System.out.println(maxValue);
    }

    // 3. Minimum Sum absolute Difference
    public static void minSum(int[] a, int[] b) { // O(nlogn)
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        System.out.println("Min sum: " + sum);
    }
    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1] );
        }
    }

    // 4. Max length chain of pairs
    public static void pairsChain(int[][] pairs) { // O(nlogn)
        // sorting
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int count = 1;
        int last = 0;
        System.out.println("(" + pairs[0][0] + "," + pairs[0][1] + ")");
        for (int i = 1; i < pairs.length; i++) {
            if(pairs[last][1] < pairs[i][0]) {
                count++;
                last = i;
                System.out.println("(" + pairs[i][0] + "," + pairs[i][1] + ")");                
            }
        }
        System.out.println("length: " + count);
    }

    // 5. Indian Coins
    public static void indianCoins(int[] notes, int v) {
        Arrays.sort(notes);
        int ans = 0;
        for (int i = notes.length - 1; i >= 0; i--) {
            if(notes[i] <= v) {
                int n = v / notes[i];
                v -= (notes[i] * n);
                ans += n;
                System.out.println(n + " x " + notes[i]);
            }
        }
        System.out.println("ans: " + ans);
    }

    // 6. Job Sequencing Problem
    static class job {
        int profit, deadline, id;
        public job(int p, int d, int i) {
            profit = p;
            deadline = d;
            id = i;
        }
    }
    public static void jobSequencing(int[][] jobsInfo) {
        // Arraylist jobs
        ArrayList<job> jobs = new ArrayList<>();
        
        // Assigning values
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new job(jobsInfo[i][1], jobsInfo[i][0], i));
        }

        // sorting
        Collections.sort(jobs, (a,b) -> b.profit - a.profit); // descending order of profit
        int time = 0;
        ArrayList<Integer> seq = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            if(jobs.get(i).deadline > time) {
                time++;
                seq.add(jobs.get(i).id);
            }
        }
        System.out.println("max jobs: " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.println("job" + seq.get(i));
        }
    }

    // 7. Chocola Problem
    public static void Chocola(Integer[] vc, Integer[] hc) {
        Arrays.sort(vc, Collections.reverseOrder());
        Arrays.sort(hc, Collections.reverseOrder());
        int vi, hi;
        int hp = 1;
        int vp = 1;

        int cost = 0;
        vi = 0;
        hi = 0;
        while(vi < vc.length && hi < hc.length) {
            int vCost = vc[vi];
            int hCost = hc[hi];
            if(vCost >= hCost) {
                cost += vCost * hp;
                vp ++;
                vi++;
            } else {
                cost += hCost * vp;
                hp ++;
                hi++;
            }
        }
        while(vi < vc.length) {
            int vCost = vc[vi];
            cost += vCost * hp;
                vp ++;
                vi++;
        }
        while(hi < hc.length) {
            int hCost = hc[hi];
            cost += hCost * vp;
                hp ++;
                hi++;
        }

        System.out.println("total cost: " + cost);
    }

    public static void main(String[] args) {
        // 7. Chocola Problem
        Integer[] verticalCost = {2, 1, 3, 1, 4};
        Integer[] horizontalCost = {4, 1, 2};
        Chocola(verticalCost, horizontalCost);

        // 6. Job Sequencing
        // int[][] jobsInfo = {
        //     {4,20},
        //     {1,10},
        //     {1,40},
        //     {1,30}
        // };
        // jobSequencing(jobsInfo);

        // 5. Indian coins
        // int[] notes = {1,2,5,10,20,50,100,500,2000};
        // indianCoins(notes, 590);

        // 4. max length chain of pairs
        // int pairs[][] = {
        //     {5,24},
        //     {39,60},
        //     {5,28},
        //     {27,40},
        //     {50,90},
        // };
        // pairsChain(pairs);
        // 3. Min sum absolute difference
        // int a[] = {4,1,8,7};
        // int b[] = {2,3,6,5};
        // minSum(a, b);

        // 2. fractional knapsack
        // int weight[] = {10, 20, 30};
        // int value[] = {60, 100, 120};
        // knapSack(weight, value, 50);

        // 1. activity selection
        // int start[] = {0,1,3,5,5,8};
        // int end[] = {6,2,4,7,9,9};
        // System.out.println(activitySelection(start, end));
    }
}