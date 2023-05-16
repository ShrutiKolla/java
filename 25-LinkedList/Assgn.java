public class Assgn {
    public static class Node {
        int data;
        Node next; // reference obj..to point to next node

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size = 0;

    public static void addFirst(int d) {
        Node newNode = new Node(d);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }
    public static void addLast(int d) {
        Node newNode = new Node(d);
        if(head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    public static void add(int index, int d) {
        if(index == 0) {
            addFirst(d);
            return;
        }
        Node newNode = new Node(d);
        Node temp = head;
        int i = 0;
        while(i < index-1 && temp != null) {
            temp = temp.next;
            i++;
        }
        if(temp != null && i == index) {
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }
    public static int removeFirst() {
        int val = head.data;
        if(size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            head = tail = null;//same thing we're doing in els...but here!!..taile = null we're making
            size = 0;
        } else {
            head = head.next;
            size--;
        }
        return val;
    }
    public static int removeLast() {
        if(size == 0) {
            System.out.println("ll empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        } else {
            int val = tail.data;
            Node temp = head;
            Node prev = head;
            while(temp.next != null) {
                prev = temp;
                temp = temp.next;
            }//i = 0; while(i < size - 2)
            prev.next = null;
            tail = prev;
            size--;
            return val;
        }
    }
    public static void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void printLL() {
        if(head == null) {
            System.out.println("ll is empty");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "--> ");
            temp = temp.next;
        }System.out.println("null");
    }
    
    // 2nd ::

    // del n nodes after m nodes
    // 1->2->3->4->5->6->7->8
    // 1->2->5->6
    public static void remNafterN(int m, int n) {
        Node temp = head;
        while(temp != null) {
            int i = 1;
            while(i != m && temp != null) {
                temp = temp.next;
                i++;
            }
            i = 0;
            while(i != n && temp != null && temp.next != null) {
                temp.next = temp.next.next;
                i++;
            }
            temp = temp.next;
        }
    }

    //3rd::

    // Sample Input 1: 1->2->3->4,  x = 2, y = 4
    // Sample Output 1: 1->4->3->2
    public static void swap(int x, int y) {
        // 1. get 2 nodes
        Node n1 = head;
        Node n2 = head;
        Node prev1 = null;
        Node prev2 = null;
        while(n1 != null && n1.data != x) {
            prev1 = n1;
            n1 = n1.next;
        }
        while(n2 != null && n2.data != y) {
            prev2 = n2;
            n2 = n2.next;
        }
        
        System.out.println(prev1.next.data + " " + prev2.next.data);
        Node next1 = null;
        Node next2 = null;
        Node temp = prev1.next;
        next1 = prev1.next.next;
        next2 = prev2.next.next;
        prev1.next = prev2.next;
        prev1 = prev1.next;
        prev1.next = next1;
        prev2.next = temp;
        prev2 = prev2.next;
        prev2.next = next2;
        // 2. swap
    }
    public static void main(String[] args) {
        // 3::
        // addFirst(6);
        // addFirst(5);
        // addFirst(4);
        // addFirst(3);
        // addFirst(2);
        // addFirst(1);
        // printLL();
        // swap(5, 2);
        // printLL();

        // 2::
        // addFirst(10);
        // addFirst(9);
        // addFirst(8);
        // addFirst(7);
        // addFirst(6);
        // addFirst(5);
        // addFirst(4);
        // addFirst(3);
        // addFirst(2);
        // addFirst(1);
        // printLL();
        // remNafterN(3, 2);
        // printLL();

    }
}
