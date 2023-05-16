import java.util.Stack;
public class StackL {

    // public static class Node {
    //     int data;
    //     Node next;
    //     public Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class Stack {
    //     static Node head = null;

    //     // 1. is empty?
    //     public static Boolean isEmpty() {
    //         return head == null;
    //     }

    //     // 2. push opn
    //     public static void push(int data) {
    //         Node newNode = new Node(data);
    //         if(isEmpty()) {
    //             head = newNode;
    //             return;
    //         }
    //         newNode.next = head;
    //         head = newNode;
    //     }

    //     // 3. pop opn
    //     public static int pop() {
    //         if(isEmpty()) {
    //             return -1;
    //         }
    //         int val = head.data;
    //         head = head.next;
    //         return val;
    //     }

    //     // 4. peek opn
    //     public static int peek() {
    //         if(isEmpty()) {
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    public static void main(String[] args) {
        // Stack s = new Stack();
        
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
    
}
