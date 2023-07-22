public class startsWithCode {
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

    // startsWith
    public static boolean startsWith(String str) { // O(L)
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }


    public static void main(String[] args) {
        String[] words = {"apple", "app", "mango", "man", "woman"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(startsWith("apn"));
    }
}
