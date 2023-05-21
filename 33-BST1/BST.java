import java.util.*;
public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // 1. insert a node
    public static Node insert(Node root, int val) {
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

    // 2. search a node
    public static boolean search(Node root, int val) {
        if(root == null) {
            return false;
        }
        if(root.data == val) {
            return true;
        }
        if(val < root.data) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    // 3. delete a node

    public static int InorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    public static Node delete(Node root, int val) {
        if(val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            if(root.left == null && root.right == null) {
                return null;
            }
            if(root.left == null) {
                return root.right;
            } else if( root.right == null) {
                return root.left;
            } else {
                int IS = InorderSuccessor(root.right);
                root.data = IS;
                root.right = delete(root.right, IS);
            }
        }
        return root;
    }

    // 4. print in range
    public static void printIR(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printIR(root.left, k1, k2);
            System.out.print(root.data + " ");
            printIR(root.right, k1, k2);
        } else if(root.data < k1) {
            printIR(root.right, k1, k2);
        } else {
            printIR(root.left, k1, k2);
        }
    }

    // 5. root to leaf -- my approach
    public static Node paths(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return null;
        }
        path.add(root.data); 
        Node lefttree = paths(root.left, path); 
        Node righttree =  paths(root.right, path);
        if(lefttree == null && righttree == null) {
            System.out.println(path);
        }
        path.remove(path.size() - 1);
        return root;
    }
    // didi's approach
    public static void root2leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null) {
            System.out.println(path);
        }
        root2leaf(root.left, path);
        root2leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    // valid bst --> snapdeal, amazon, facebook
    /*
        8 5 3 
        8 5 6
        8 10 11 14
        8 
    */ 
    public static void main(String[] args) {
        
        /*
            ........ 8
            ......./   \
            ......5     10
            ..../   \      \
               3     6      11
             ................\
            ................. 14
        */ 

        // int values[] = {8,6,3,5,1,4,10,11,14};
        int values[] = {8,5,3,6,10,11,14};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        // System.out.println(search(root, 0));
        // delete(root, 5);
        // System.out.println();
        // printIR(root, 5, 12);

        inorder(root);
        ArrayList<Integer> path = new ArrayList<>();
        // paths(root, path);
        root2leaf(root, path);
    }
    
}
