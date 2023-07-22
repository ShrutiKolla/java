public class WordBreakCode {
    static class Node {
        Node children[];
        boolean eow;
        public Node() {
            children = new Node[26];
        }
    }
    static Node root = new Node();

    // insert
    public static void insert(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 97;
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
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
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    // wordBreak
    public static boolean wordBreak(String str) {
        if(str.length() == 0) {
            return true;
        }
        for (int i = 0; i <= str.length(); i++) {
            if(search(str.substring(0, i)) && wordBreak(str.substring(i, str.length()))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String words[] = { "the", "a", "there", "their", "any", "thee"};
        // for (int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }

        // System.out.println(search("any"));
        // System.out.println(search("any"));
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
