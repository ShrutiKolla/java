public class AVL {
    
    static class Node {
        int height, data;
        Node left, right;

        Node(int data) {
            this.data = data;
            // left = right = null;
            height = 1;
        }
    }

    public static Node root = null;
    public static int height(Node node) {
        if(node == null) {
            return 0;
        }
        return node.height;
    }

    public static int max(int a, int b) {
        return a>b?a:b;
    }

    // get balance factor
    public static int getBF(Node node) {
        if(node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Rotations
    public static Node rotateLeft(Node X) {
        Node Y = X.right;
        Node T2 = Y.left;

        // perform rotation
        Y.left = X;
        X.right = T2;

        // update heights
        X.height = max(height(X.left), height(X.right)) +1;
        Y.height = max(height(Y.left), height(Y.right)) +1;

        return Y;
    }
    public static Node rotateRight(Node X) {
        Node Y = X.left;
        Node T2 = Y.right;

        // perform rotation
        Y.right = X;
        X.left = T2;

        // update heights
        X.height = max(height(X.left), height(X.right)) +1;
        Y.height = max(height(Y.left), height(Y.right)) +1;

        return Y;
    }

    // insert fn
    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }

        // check where to insert
        if(data < root.data) {
            root.left = insert(root.left, data);
        } else if(data > root.data) {
            root.right = insert(root.right, data);
        } else { // duplicates not allowed
            return root;
        }

        // update height
        root.height = max(height(root.left), height(root.right)) + 1;

        // check balanced or not --> if not rotate
        int bf = getBF(root);

        if(bf > 1 && data < root.left.data) {
            /*
                LL:     X     LR:   X    RR:   X    RL:   X
                       /           /            \          \
                      Y           Y              Y          Y
                     /             \              \        /
                   new              new           new    new

            */ 
            return rotateRight(root);
        } if(bf > 1 && data > root.left.data) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        } if(bf < -1 && data > root.right.data) {
            return rotateLeft(root);
        } if(bf < -1 && data < root.right.data) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }
        return root; // --> no balancing required
        
    }

    // preorder
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root,10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        preorder(root);
    }
}
