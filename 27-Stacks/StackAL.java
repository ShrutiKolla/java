import java.util.ArrayList;
public class StackAL {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        // 1. is empty?
        public Boolean isEmpty() {
            return list.size() == 0;
        }

        // 2. push opn
        public void push(int data) {
            list.add(data);
        }

        // 3. pop opn
        public int pop() {
            if(isEmpty()) {
                return -1;
            }
            int val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return val;
        }

        // 4. peek opn
        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}