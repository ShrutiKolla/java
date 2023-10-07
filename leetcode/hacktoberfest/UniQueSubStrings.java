/*
    Explanation -->
        We can count the number of unique substrings using 2 ways :
        1. Unique prefixes of all sufixes  
        2. Unique sufixes of all prefixes  

        We will be using the 1st method here

        Let the word be "Shruti",
        All Suffixes : "Shruti", "hruti", "ruti", "uti", "ti", "i"
        Unique Substrings : "Shruti", "Shrut", "Shru", "Shr", "Sh", "S", "",
                            "hruti", "hrut", "hru", "hr", "h",
                            "ruti", "rut", "ru", "r",
                            "uti", "ut", "u",
                            "ti", "t",
                            "i".
        -----------------------------------------------------------------------
                            Unique Substrings : 22
*/

public class UniQueSubStrings {
    static class Node {
        Node[] children;
        boolean eow; // end of word --> by default : false

        public Node() {
            children = new Node[26];
        }
    }

    static Node root = new Node();

    // insertion
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 97;
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true; // word ended
    }

    // count nodes in the trie
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

    public static void main(String[] args) {
        String word = "shruti";
        for (int i = 0; i < word.length(); i++) {
            insert(word.substring(i, word.length()));
        }
        System.out.println("Number of Unique Substrings : " + countNodes(root));
    }
}