public class PrefixProblemCode {
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

    // search
    public static boolean search(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 97;
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    // unique prefix
    public static void uniquePrefix(Node root, String str) {
        if(root == null) {
            return;
        }
        if(root.freq == 1) {
            System.out.print(str + ", ");
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                uniquePrefix(root.children[i], str + (char)(i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "zebra", "dog", "duck", "dove"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        uniquePrefix(root, "");
    }
}
