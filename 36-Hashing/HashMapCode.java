import java.util.*;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K,V> {
        public class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n --> no of nodes
        private int N;
        private LinkedList<Node> bucket[]; // N=bucket.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            n = 0;
            N = 4;
            this.bucket = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                bucket[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = bucket[bi]; // ll at bi
            for (int i = 0; i < ll.size(); i++) {
                if(ll.get(i).key == key) {
                    System.out.println("exists at " + i);
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            // store prev bucket in old bucket
            LinkedList<Node> oldBucket[] = bucket;
            N = 2*N;
            
            // reinitialize the bucket
            bucket = new LinkedList[N];
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        // 1. put opn
        public void put(K key, V value) {
            int bi = hashFunction(key); // bucket idx
            int di = searchInLL(key, bi); // data idx

            // di valid : update
            if(di != -1) {
                Node node = bucket[bi].get(di);
                node.value = value;
            } else {
                bucket[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double)n/N;
            if(lambda > 2.0) {
                rehash();
            }
        }

        // 2. containsKey
        public Boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                return true;
            } else {
                return false;
            }
        }

        // 3. get
        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                return bucket[bi].get(di).value;
            } else {
                return null;
            }
        }
        public void print() {
            System.out.println("n : " + n);
            System.out.println("N : " + N);
            for (int i = 0; i < bucket.length; i++) {
                LinkedList<Node> ll = bucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    System.out.print(node.key + " : " + node.value + " , ");
                } System.out.println();

            }
        }

    }

    public static void main(String[] args) {
        HashMap<String,Integer> pop = new HashMap<>();
        pop.put("India", 100);
        pop.put("China", 150);
        pop.put("US", 50);
        pop.put("India", 80);
        pop.put("Indo", 50);
        // pop.print();
        System.out.println(pop.containsKey("China"));
    }
}
