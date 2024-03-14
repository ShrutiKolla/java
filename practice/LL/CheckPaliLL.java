public class CheckPaliLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
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

    // slow-fast
    Node midNode() {
        Node slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // reverse --> return head of rev ll
    Node reverse(Node h2) {
        Node tmp = h2;
        Node prev = null, next = null;

        while(tmp != null) {
            next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;    
        }
        h2 = prev;
        return h2;
    }
    boolean checkPali() {
        if(head == null) {
            return true;
        }
        // slow fast --> mid
        Node mid = midNode(); 
        // 2nd half rev
        mid = reverse(mid);
        // check 1st half and rev same /not
        Node tmp1 = head;
        Node tmp2 = mid;
        printLL(mid);
        while(tmp2 != null) {
            if(tmp1.data != tmp2.data) {
                return false;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        CheckPaliLL ll = new CheckPaliLL();
        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(3);
        ll.addLast(1);
        ll.printLL(ll.head);
        System.out.println(ll.checkPali());
    }
}
