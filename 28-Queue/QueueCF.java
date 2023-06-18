import java.util.*;
import java.util.LinkedList;
public class QueueCF {
    // 4::
    public static void nonRepeating(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 97]++;
            q.add(ch);
            while(!q.isEmpty() && freq[q.peek() - 97] != 1) {
                q.remove();
            }
            if(!q.isEmpty()) {
                System.out.println(q.peek());
            } else {
                System.out.println(-1);
            }
        }
    }

    // 5::
    public static void interleave(Queue<Integer> q) {
        int size = q.size();
        System.out.println(size);
        Queue<Integer> q1 = new LinkedList<>();
        for (int i = 0; i < size / 2; i++) {
            q1.add(q.remove());
        }

        while(!q1.isEmpty()) {
            q.add(q1.remove());
            q.add(q.remove());
        }
    }

    // 6::
    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()) {
            s.push(q.remove());
        }
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    // 7:: implementing stack
    static class StackF {
        Deque<Integer> deque = new LinkedList<>();

        public Boolean isEmpty() {
            return deque.isEmpty();
        }
        public void push(int data) {
            deque.add(data);
        }
        public int pop() {
            if(deque.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return deque.removeLast();
        }
        public int peek() {
            if(deque.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return deque.peekLast();
        }
    }

    //  :: implementing queue
    static class QueueF {
        Deque<Integer> deque = new LinkedList<>();

        public Boolean isEmpty() {
            return deque.isEmpty();
        }
        public void add(int data) {
            deque.add(data);
        }
        public int remove() {
            if(deque.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return deque.removeFirst();
        }
        public int peek() {
            if(deque.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return deque.peekFirst();
        }
    }
    public static void main(String[] args) {
        // 7.
        StackF s = new StackF();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        QueueF q = new QueueF();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println();
        while(!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        // 6.
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // reverse(q);
        // while(!q.isEmpty()) {
        //     System.out.print(q.remove() + " ");
        // }

        // 5.
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);
        // interleave(q);
        // while(!q.isEmpty()) {
        //     System.out.print(q.remove() + " ");
        // }

        // 4.
        // String str = "aabccxb";
        // nonRepeating(str);
    }
}
