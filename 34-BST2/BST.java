import java.util.*;
import java.util.LinkedList;
public class BST {
    
    // Pre-requisites
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static Node insert (Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }

    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                }
                q.add(curr);
                System.out.println();
            } else {
                System.out.print(curr.data + " ");
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // 1. convert sorted arr to balanced bst
    public static Node balance(Node root, int[] arr, int st, int ed) {
        if(st > ed) {
            return null;
        }
        int mid = (st + ed) /2;
        root = new Node(arr[mid]);
        root.left = balance(root.left, arr, st, mid - 1);
        root.right = balance(root.right, arr, mid + 1, ed);
        return root;
    }

    // 2. convert bst to balanced bst
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node balance2(ArrayList<Integer> inorder, int st, int ed) {
        if(st > ed) {
            return null;
        }
        int mid = (st + ed)/2;
        Node root = new Node(inorder.get(mid));
        root.left = balance2(inorder, st, mid - 1);
        root.right = balance2(inorder, mid + 1, ed);
        return root;
    }
    public static Node balancedBST(Node root) {
        // get inorder
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        return balance2(inorder, 0, inorder.size() - 1);
    }
    public static void main(String[] args) {
        // int values[] = {8,5,3,6,11,10,12};
        // Node root = null;
        // for (int i = 0; i < values.length; i++) {
        //     root = insert(root, values[i]);
        // }
        // inorder(root);
        // System.out.println();
        // levelOrder(root);

        // 1. sorted arr to balanced bst
        // Node root = null;
        // int arr[] = {3, 5, 6, 8, 10, 11, 12};
        // root = balance(root, arr, 0, arr.length - 1);
        // inorder(root);
        // System.out.println();
        // levelOrder(root);

        // 2.
        int arr[] = {1,3,2,4,8};
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        levelOrder(root);
        System.out.println();
        inorder(root);
        root = balancedBST(root);
        System.out.println();
        levelOrder(root);
        System.out.println();
        inorder(root);
    }
}
