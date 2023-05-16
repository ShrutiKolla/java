public class QueueLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static Node head;
    static Node tail;
    
    static class Queue {
        public Queue() {
            head = tail = null;
        }

        // is empty 
        public Boolean isEmpty() {
            return head == null;
        }
        // add - to rear
        public void add(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        // remove - from front
        public int remove() {
            if(head == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return data;
        }
        // peek - head
        public int peek() {
            if(head == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()) {
            System.out.println(q.remove());
            // q.remove();
        }
    }
}
