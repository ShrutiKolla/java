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
            if(level == k) {
                System.out.print(root.data + " ");
                return;
            }
            if(root == null) {
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

    }
    public static void main(String[] args) {

        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        ArrayList<Integer> path = new ArrayList<>();
        System.out.println(root.left.right.data);
        tree.findLCA(root, 7, 6);
        // 4. kth level nodes

        // int[] nodes1 = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        // BinaryTree tree1 = new BinaryTree();
        // Node root = tree1.buildTree(nodes1);   
        // tree1.kLevel(root, 1, 2);


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
