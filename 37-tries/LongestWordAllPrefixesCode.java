public class LongestWordAllPrefixesCode {
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

    static String ans = "";
    // longest word with all prefixes
    public static void LongestPrefixString(Node root, String temp){
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                temp = temp + (char)('a' + i);
                LongestPrefixString(root.children[i], temp);
                if(ans.length() < temp.length()) {
                    ans = temp;
                }
                temp = temp.substring(0, temp.length()-1);
            }            
        }
    }
    public static void main(String[] args) {
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple", "b", "ba", "ban", "bana", "banan"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        LongestPrefixString(root, "");
        System.out.println(ans);
    }
}
