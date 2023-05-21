import java.util.*;
import java.util.LinkedList;

import javax.xml.crypto.dsig.Transform;
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
        int idx = -1;
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

        public int countNodes(Node root) {
            if(root == null) {
                return 0;
            }
            int leftC = countNodes(root.left);
            int rightC = countNodes(root.right);
            return leftC + rightC + 1;
        }

        public int sumNodes(Node root) {
            if(root == null) {
                return 0;
            }
            int leftS = sumNodes(root.left);
            int rightS = sumNodes(root.right);
            return root.data + leftS + rightS;
        }

        // Approach 1
        public int diam(Node root) {
            if(root == null) {
                return 0;
            }
            int leftDia = diam(root.left);
            int rightDia = diam(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            int self = lh + rh + 1;
            return Math.max(Math.max(self, leftDia), rightDia);
        }

        // 3. Diameter
        // Approach 2
        public class info{
            int diam;
            int height;
            public info(int d, int h) {
                diam = d;
                height = h;
            }
        }

        public info Diam(Node root) {
            if(root == null) {
                return new info(0, 0);
            }
            int leftDia = Diam(root.left).diam;
            int rightDia = Diam(root.right).diam;

            int lh = Diam(root.left).height;
            int rh = Diam(root.right).height;
            int currH = Math.max(lh, rh) + 1;
            int self = leftDia + rightDia + 1;
            int currDiam = Math.max(self, Math.max(leftDia, rightDia));
            return new info(currDiam, currH);
        }

        public static Boolean isIdentical(Node node, Node subRoot) {
            if(node == null && subRoot == null) {
                return true;
            } else if(node == null || subRoot == null || node.data != subRoot.data) {
                return false;
            }
            if(!isIdentical(node.left, subRoot.left)) {
                return false;
            }
            if(!isIdentical(node.right, subRoot.right)) {
                return false;
            }
            
            return true;
        }
        public static Boolean isSubTree(Node root, Node subRoot) {
            
            if(root == null) {
                return false;
            }
            if(root.data == subRoot.data) {
                if(isIdentical(root, subRoot)) {
                    return true;
                }
            }
            return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
        }

        // Top view
        static class data {
            Node node;
            int hd;
            data(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public void topView(Node root) {
            // level order traversal 
            
            Queue<data> q = new LinkedList<>();
            q.add(new data(root, 0));

            // if unique hd..store in hash
            int min, max;
            min = max = 0;

            HashMap<Integer, Node> map = new HashMap<>();

            while(!q.isEmpty()) {
                data newData = q.remove();
                if(map.get(newData.hd) == null) {
                    min = Math.min(min, newData.hd);
                    max = Math.max(max, newData.hd);
                    map.put(newData.hd, newData.node);
                }
                if(newData.node.left != null) {
                    q.add(new data(newData.node.left, newData.hd - 1));
                }
                if(newData.node.right != null) {
                    q.add(new data(newData.node.right, newData.hd + 1));
                }
            }
            
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }

        // 4. kth level nodes
        public void kLevel(Node root, int level, int k) {
            if(root == null) {
                return;
            }
            if(level == k) {
                System.out.print(root.data + " ");
                return;
            }
            kLevel(root.left, level + 1, k);
            kLevel(root.right, level + 1, k);
        }

        // 5. lowest common ancestor
        public Boolean findPath(Node root, int node, ArrayList<Integer> path) {
            if(root == null) {
                return false;
            }
            if(root.data == node) {
                path.add(root.data);
                return true;
            }
            path.add(root.data);
            if(findPath(root.left, node, path)) {
                return true;
            }
            if(findPath(root.right, node, path)) {
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }
        public void findLCA(Node root, int n1, int n2) {
            ArrayList<Integer> path1 = new ArrayList<>();
            ArrayList<Integer> path2 = new ArrayList<>();

            findPath(root, n1, path1);
            findPath(root, n2, path2);
            int i = 0;
            for (i = 0; i < path1.size() ; i++) {
                if(path1.get(i) != path2.get(i)) {
                    break;
                }
            }
            System.out.println("common ancestor: " + path1.get(i - 1));
        }

        // 5.2 findlca approach 2
        public Node lca(Node root, int n1, int n2) {
            if(root == null || root.data == n1 || root.data == n2) {
                return root;
            }
            Node leftLCA = lca(root.left, n1, n2);
            Node rightLCA = lca(root.right, n1, n2);
            if(leftLCA == null) {
                return rightLCA;
            }
            if(rightLCA == null) {
                return leftLCA;
            }
            return root;
        }

        // 6. Min dist between 2 nodes

        public int distLca(Node root, int node) {
            if(root == null) {
                return -1;
            }
            if(root.data == node) {
                return 0;
            }
            int leftDist = distLca(root.left, node);
            int rightDist = distLca(root.right, node);
            if(leftDist > -1) {
                return leftDist + 1;
            }
            if(rightDist > -1) {
                return rightDist + 1;
            }
            return -1;
        }
        public int minDist(Node root, int n1, int n2) {
            Node LCA = lca(root, n1, n2);
            int dist1 = distLca(LCA, n1);
            int dist2 = distLca(LCA, n2);
            return dist1 + dist2;
        }

        // 7. kth ancestor of a node
        public int kAncestor(Node root, int node, int k) {
            if(root == null) {
                return -1;
            }
            if(root.data == node) {
                return 0;
            }
            int leftDist = kAncestor(root.left, node, k);
            int rightDist = kAncestor(root.right, node, k);

            if(leftDist == -1 && rightDist == -1) {
                return -1;
            }
            int max = Math.max(leftDist, rightDist) + 1;
            if(max == k) {
                System.out.println(k + "th ancestor: " + root.data);
            }
            return max;
        }

        // 8. Transform to a sum tree
        public int transform(Node root) {
            if(root == null) {
                return 0;
            }
            int data = root.data;
            int leftChild = transform(root.left);
            int rightChild = transform(root.right);
            int totleft = root.left == null ? leftChild : root.left.data + leftChild; 
            int totright = root.right == null ? rightChild : root.right.data + rightChild; 
            root.data = totleft + totright;
            return data;
        }
    }
    public static void main(String[] args) {
        // 8. transform to sum tree
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // tree.transform(root);
        // tree.levelOrder(root);
        
        // 7. kth ancestor of a node
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // tree.kAncestor(root, 6, 1);

        /*
                     1
                   /   \
                  2     3
                 / \   / \
                4   5 6   7
        */ 

        // 6. Min dist between 2 nodes
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // int n1 = 2;
        // int n2 = 7;
        // System.out.println(tree.minDist(root, n1, n2));


        // 5. find lowest common ancestor
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.left.right.data);
        // tree.findLCA(root, 7, 6);

        // 2nd approach
        // System.out.println(tree.lca(root, 7, 6).data);
        
        // 4. kth level nodes

        int[] nodes1 = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree1 = new BinaryTree();
        Node root = tree1.buildTree(nodes1);   
        tree1.kLevel(root, 1, 4);


        // 3. Diammeter approach 2
        // BinaryTree tree = new BinaryTree();
        // int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        // Node root = tree.buildTree(nodes);   
        // System.out.println(tree.Diam(root).diam);

        // System.out.println();
        // ArrayList<Integer> path = new ArrayList<>();
        // tree1.findPath(root, root.left.right, path);
        // System.out.println(path);
        // tree1.topView(root);
        
        
        // BinaryTree tree2 = new BinaryTree();
        // int[] nodes2 = {2,4,-1,-1,5,-1,-1};
        // Node subRoot = tree2.buildTree(nodes2);
        // tree2.preOrder(subRoot);
        
        // System.out.println(BinaryTree.isSubTree(root, subRoot));
    }
}
