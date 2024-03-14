public class LinkedList {
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

    public static int search(int key) {
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            i++;temp = temp.next;
        }
        return -1;
    }

    public static int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx +1;
    }
    public static int searchRec(int key) {
        return helper(head, key);
    }

    //9.
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

    public static void remNthEnd(int n) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            sz ++;
            temp = temp.next;
        }
        if(n == size) {
            head = head.next;
            return;
        }
        Node prev = head;
        for(int i = 1; i < sz-n; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    // my approach
    public static Boolean palindromeLL() {
        int num = 0;
        int rev_num = 0;
        int half = size/2;
        Node temp = head;
        for(int i = 0; i < half ; i++) {
            num = num*10 + temp.data;
            temp = temp.next;
        }
        System.out.println("num: " + num);
        int pow = 0;
        if(size % 2 != 0) {
            temp = temp.next;
        }
        for(int i = 0 ; i < half;i++) {
            rev_num += temp.data*Math.pow(10, pow);
            pow++;
            temp = temp.next;
        }
        System.out.println("rev_num: " + rev_num);
        if(num == rev_num) {
            return true;
        }
        return false;
    }

    // didi's approach

    // 1. slow fast approach
    public  Node findMid() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 2. reverse 2nd half
    public Node rev(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } head = prev;
        return head;
    }

    // 3. check left and right
    public Boolean paliLL() {
        if(head == null || head.next == null) {
            return true;
        }
        Node midNode = findMid();

        // Node head1 = rev(midNode); // head of reversed 2nd half
        // Node right = head1;

        //2. reverse 2nd half
        Node curr = midNode;
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // head of reversed 2nd half
        Node left = head;
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        addLast(1);
        addLast(3);
        addLast(3);
        addLast(1);
        System.out.println(ll.paliLL());
    }
}