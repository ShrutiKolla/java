import java.util.*;
public class QueueSt {
    // 2::
    // Queue using 2 stacks
    static class QueueF {
        Stack<Integer> s1;
        Stack<Integer> s2;
        public QueueF() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }
        public Boolean isEmpty() {
            return s1.isEmpty();
        }
        public void add(int data) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
        public int remove() {
            if(s1.isEmpty()) {
                System.out.println("queue empty");
                return -1;
            }
            return s1.pop();
        }
        public int peek() {
            if(s1.isEmpty()) {
                System.out.println("queue empty");
                return -1;
            }
            return s1.peek();
        }
    }   

    // 3::
    // Stack using 2 queues
    static class StackF {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // is empty
        public Boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // add - O(1)
        public void push(int data) {
            if(isEmpty()) {
                q1.add(data);
                return;
            }
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // remove - O(n)
        public int pop() {
            if(isEmpty()) {
                System.out.println("Stack empty");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        // peek
        public int peek() {
            if(isEmpty()) {
                System.out.println("Stack empty");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }

    }
    public static void main(String[] args) {


        // 1.
        // StackF s = new StackF();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // while(!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        // 2.
        // QueueF q = new QueueF();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // while(!q.isEmpty()) {
        //     System.out.println(q.remove());
        // }
    } 
}
