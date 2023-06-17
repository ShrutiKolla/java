import java.util.*;
public class triess {

    // 0. creation
    static class Node {
        Node children[] = new Node[26];
        Boolean eow = false; // endOfWord
        int freq;
        public Node () {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }
    static Node root = new Node();

    // 1. insertion --> O(L) --> L : length of the longest string
    public static void insert(String s) {
        Node curr = root;
        // curr.freq = -1;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.freq++;
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

    // 3. word break problem
    public static Boolean wordBreak(String key) {
        if(key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if(search(key.substring(0, i)) 
            && wordBreak(key.substring(i, key.length()))) {
                return true;
            } 
        }
        return false;
    }

    // 4. prefix problem
    public static void uniquePrefix(Node root, String a) {
        if(root == null) {
            return;
        }
        if(root.freq == 1) {
            System.out.print(a + " ");
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null) {
                uniquePrefix(root.children[i], a + (char)(i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        // 4. prefix Problem --> uniquePrefix
        String word[] = {"zebra", "dog", "duck", "dove"};
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        root.freq = -1;
        uniquePrefix(root, "");

        // 3. word break problem
        /*String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        String key = "samsungilike";
        System.out.println(wordBreak(key));*/

        /*String words[] = { "the", "a", "there", "their", "any", "thee"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("an"));*/
    }

}
