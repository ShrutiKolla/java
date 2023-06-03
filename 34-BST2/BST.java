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

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }
                q.add(curr);
                System.out.println();
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // 1. convert sorted arr to balanced bst
    public static Node balance(Node root, int[] arr, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
        root = new Node(arr[mid]);
        root.left = balance(root.left, arr, st, mid - 1);
        root.right = balance(root.right, arr, mid + 1, ed);
        return root;
    }

    // 2. convert bst to balanced bst
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node balance2(ArrayList<Integer> inorder, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
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

    // 3. size of largest BST

    public static int maxBST = 0;

    static class Info {
        Boolean isBST;
        int size, min, max;

        public Info(Boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    // 4. merge 2 bsts

    public static void mergeInorder(ArrayList<Integer> inorder, ArrayList<Integer> inorder1, ArrayList<Integer> inorder2) {
        int i1 = inorder1.size();
        int i2 = inorder2.size();
        int i = 0;
        int j = 0;
        while(i < i1 && j < i2) {
            int val1 = inorder1.get(i);
            int val2 = inorder2.get(j);
            if(val1 < val2) {
                inorder.add(val1);
                i++;
            } else if(val1 == val2) {
                inorder.add(val1);
                i++;j++;
            } else {
                inorder.add(val2);
                j++;
            }
        }
        while(i < i1) {
            inorder.add(inorder1.get(i));
            i++;
        }
        while(j < i2) {
            inorder.add(inorder2.get(j));
            j++;
        }
    }

    public static Node getBST(ArrayList<Integer> inorder, int st, int ed) {
        if(st > ed) {
            return null;
        }
        int mid = (st + ed) /2;
        Node root = new Node(inorder.get(mid));
        root.left = getBST(inorder, st, mid - 1);
        root.right = getBST(inorder, mid + 1, ed);
        return root;
    }
    public static Node merge(Node root1, Node root2) {
        ArrayList<Integer> inorder1 = new ArrayList<>();
        ArrayList<Integer> inorder2 = new ArrayList<>();
        
        getInorder(root1, inorder1);
        getInorder(root2, inorder2);
        
        ArrayList<Integer> inorder = new ArrayList<>(); 
        mergeInorder(inorder, inorder1, inorder2);
        return getBST(inorder, 0, inorder.size() - 1);
    }

    public static void main(String[] args) {
        // int values[] = {8,5,3,6,11,10,12};
        // Node root = null;
        // for (int i = 0; i < values.length; i++) {
        // root = insert(root, values[i]);
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
        // int arr[] = {1,3,2,4,8};
        // Node root = null;
        // for (int i = 0; i < arr.length; i++) {
        // root = insert(root, arr[i]);
        // }
        // levelOrder(root);
        // System.out.println();
        // inorder(root);
        // root = balancedBST(root);
        // System.out.println();
        // levelOrder(root);
        // System.out.println();
        // inorder(root);

        //3. size of largest bst
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);
        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);
        // Info info = largestBST(root);
        // System.out.println(maxBST);

        // 4. merge 2 bsts
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
System.out.println(root1.right.right);        
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = merge(root1, root2);
        inorder(root);
    }
}
