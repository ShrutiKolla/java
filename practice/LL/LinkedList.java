public class LinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head = null;
    Node tail = null;

    void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    Node findMid() {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    Node revLL(Node h) {
        Node tmp = h;
        Node prev = null, next = null;
        while(tmp != null) {
            next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;
        }
        h = prev;
        return h;
    }
    void zigZag() {
        Node mid = findMid();
        Node lhead = head;
        Node rhead = mid.next;
        mid.next = null;
        rhead = revLL(rhead);
        while(lhead != null && rhead != null) {
            Node lnext = lhead.next;
            lhead.next = rhead;
            Node rnext = rhead.next;
            rhead.next = lnext;
            lhead = lnext;
            rhead = rnext; 
        }
        printLL(head);
    }
    void printLL(Node h) {
        if(h == null) {
            return;
        }
        Node tmp = h;
        while(tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.printLL(ll.head);
        System.out.println();
        ll.zigZag();
    }
}