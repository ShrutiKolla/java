public class LinkedList2 {
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public  void printLL(Node head) {
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
    public static void addFirst(int d) {
        Node newNode = new Node(d);
        if(head == null) {
            head = tail = newNode;
            // size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        // size++;
    }
    public static Boolean checkCycle() {// Floyd's cycle finding algo
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void remCycle() {
        Boolean check = false;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                check = true;
                break;
            }
        }
        if(check == false) {
            return;
        }

        if(check) {
            slow = head;
            Node prev = null;
            while(slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            prev.next = null;
        }
    }

    //3. Merge Sort

    public Node mergeSort(Node head) {
        //base case

        if(head == null || head.next == null) {
            return head;
        }
        // 1.find mid
        Node midNode = findMid(head);
        Node Rhead = midNode.next;
        midNode.next = null;
        Node Lhead = head;

        // 2. left and right heads
        Node newLeft = mergeSort(Lhead);
        Node newRight = mergeSort(Rhead);
        // 3. call merge

        return merge(newLeft, newRight);
    }

    private Node findMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null &&  fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node h1, Node h2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(h1 != null && h2 != null) {
            if(h1.data < h2.data) {
                temp.next = h1;
                temp = temp.next;
                h1 = h1.next;
            } else {
                temp.next = h2;
                temp = temp.next;
                h2 = h2.next;
            }
        }
        while(h1 != null) {
            temp.next = h1;
            temp = temp.next;
            h1 = h1.next;
        }
        while(h2 != null) {
            temp.next = h2;
            temp = temp.next;
            h2 = h2.next;
        }
        temp.next = null;
        return mergedLL.next;
    }

    // 4. zig-zag ll
    public static void zigZag() {
        // 1. find mid
        Node slow = head;
        Node fast = head.next;
        Node prev = null;
        while(fast != null && fast.next != null) {
            // prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        // prev.next = null;
        // 2. reverse 2nd half
        Node curr = slow;
        prev = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node Rhead = prev;
        Node Lhead = head;
        // 3. combine alternatively
        // Node temp = new Node(-1);
        // Node th = temp;
        Node nextL, nextR;
        while(Rhead != null && Lhead != null) {
            nextL = Lhead.next;
            Lhead.next = Rhead;
            nextR = Rhead.next;
            Rhead.next = nextL;
            Rhead = nextR;
            Lhead = nextL;
            // th.next = Lhead;
            // th = th.next;
            // Lhead = Lhead.next;
            // th.next = Rhead;
            // th = th.next;
            // Rhead = Rhead.next;

        }
        // while(Lhead != null) {
        //     th.next = Lhead;
        //     th = th.next;
        //     Lhead = Lhead.next;
        // }
        // while(Rhead != null) {
        //     th.next = Rhead;
        //     th = th.next;
        //     Rhead = Rhead.next;
        // }
        // th.next = null;
        // temp = temp.next;
        
        // return temp;
    }
    public static Node head = null;
    public static Node tail = null;
    public static void main(String[] args) {
        LinkedList2 ll = new LinkedList2();
        // addFirst(5);
        addFirst(4);
        addFirst(3);
        addFirst(2);
        addFirst(1);
        ll.printLL(head);

        zigZag();
        ll.printLL(head);

        // head = ll.mergeSort(head);
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // 1-->2-->3-->2
        // System.out.println(checkCycle());
        // remCycle();
        // printLL();
    }
    
}
