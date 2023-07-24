import java.util.*;

public class AnagramsCode {

    static class Node {
        ArrayList<String> data;
        boolean eow;
        Node[] children;

        public Node() {
            data = new ArrayList<>();
            children = new Node[26];
        }
    }

    static Node root = new Node();
    static List<List<String>> ans;

    // insert
    public static void insert(String str) {
        ans = new ArrayList<>();
        Node curr = root;
        char[] letters = str.toCharArray();
        Arrays.sort(letters);
        for (char c : letters) {
            int idx = c - 97;
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }
        curr.eow = true;
        curr.data.add(str);
    }

    public static void dfs(Node rt) {
        if (rt.eow == true) {
            ans.add(rt.data);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (rt.children[i] != null) {
                dfs(rt.children[i]);
            }
        }
    }

    // anagrams
    public static List<List<String>> anagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            insert(strs[i]);
        }
        dfs(root);
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(anagrams(strs));
    }
}
