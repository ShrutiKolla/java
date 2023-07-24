public class uniqueSubstringsCode {
    static class Node {
        Node children[];
        boolean eow;
        int freq;

        public Node() {
            children = new Node[26];
            freq = -1;
        }
    }

    static Node root = new Node();

    // insert
    public static void insert(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 97;
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
                curr.children[idx].freq = 1;
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // unique substrs
    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static int uniqueSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i));
        }
        return countNodes(root);
    }
    
    public static void main(String[] args) {
        String str = "ababa";
        System.out.println(uniqueSubstrings(str));
    }
}
