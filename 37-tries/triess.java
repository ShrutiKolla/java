import java.util.*;
public class triess {

    // 0. creation
    static class Node {
        Node children[];
        Boolean eow; // endOfWord
        public Node () {
            children = new Node[26];
            eow = false;
        }
    }
    static Node root = new Node();

    // 1. insertion --> O(L) --> L : length of the longest string
    public static void insert(String s) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // 2. search
    public static Boolean search(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        if(curr.eow == true) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any", "thee"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("an"));
    }

}
