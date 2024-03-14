
public class MergeSortLL {

    public static class Node {
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

    Node findMid() {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node leftH, Node rightH) {
        Node newLL = new Node(-1);
        
    }
    public Node mergeSort(Node h) {
        if(h == null || h.next == null) {
            return h;
        }

        Node mid = findMid();
        Node rightH = mid.next;
        Node leftH = h;
        mid.next = null;
        leftH = mergeSort(leftH);
        rightH = mergeSort(rightH);
        return merge(leftH, rightH);
    }
    public static void main(String[] args) {
        MergeSortLL ll = new MergeSortLL();
        ll.addLast(5);
        ll.addLast(9);
        ll.addLast(11);
        ll.addLast(3);
        ll.addLast(8);
        
    }
}
