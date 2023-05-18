import java.util.*;
import java.util.LinkedList;
public class binTree {
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

    static class BinaryTree {
        static int idx = -1;
        public Node buildTree(int[] nodes) {
            idx++;
            if(nodes[idx] == -1) { // 1st node is null
                return null; // root is null
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        public void preOrder(Node root) {
            if(root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public void inOrder(Node root) {
            if(root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
        public void postOrder(Node root) {
            if(root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public void levelOrder(Node root) {
            if(root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {
                Node curr = q.remove();
                if(curr == null) {
                    System.out.println();
                    if(!q.isEmpty()){
                        q.add(null);
                    } else {
                        break;
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if(curr.left != null) {
                        q.add(curr.left);
                    }
                    if(curr.right!= null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        public int height(Node root) {
            if(root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return 1 + Math.max(lh, rh);
        }
    }
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);   
        // System.out.println(root.data);
        // tree.preOrder(root);
        System.out.println(tree.height(root));
    }
}
