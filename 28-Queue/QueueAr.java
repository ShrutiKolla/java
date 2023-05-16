public class QueueAr {
    static class Queue {
        static int arr[] ;
        static int size;
        static int rear;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public Boolean isEmpty() {
            return rear == -1;
        }

        public void Add(int data) {
            if(rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public int Remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return data;
        }

        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

    }

    static class CircularQueue {
        static int arr[];
        static int Size;
        static int front;
        static int rear;

        public CircularQueue(int n) {
            arr = new int[n];
            Size = n;
            front = -1;
            rear = -1;
        }

        // is empty
        public Boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        // is full
        public Boolean isFull() {
            return (rear + 1) % Size == front;
        }

        // add
        public void Add(int data) {
            if(isFull()) {
                System.out.println("Queue is full");
                return;
            }
            // inserting el for the first time
            if(rear == -1) {
                front = 0;
            }
            rear = (rear + 1) % Size;
            arr[rear] = data;
        }

                // remove
        public int Remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int data = arr[front];
            // if only one ele remaining;
            if(front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % Size;
            }
            return data;
        }
        // peek
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.Add(0);
        q.Add(1);
        q.Add(2);
        while(!q.isEmpty()) {
            System.out.println(q.Remove());
        }

        // CircularQueue cq = new CircularQueue(3);
        // cq.Add(1);
        // cq.Add(2);
        // cq.Add(3);
        // cq.Remove();
        // cq.Add(4);
        // cq.Remove();
        // cq.Add(5);
        // while(!cq.isEmpty()) {
        //     System.out.println(cq.Remove());
        // }
    }
}