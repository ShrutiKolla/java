public class exe {
    static boolean alphabets[] = new boolean[26];
    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        int larlen = 0;
        boolean c = false;
        for(int i = 0; i < s.length() ; i++) {
            if(s.charAt(i) == ' ') {
                if(c == true) {
                    len = 0;
                    i--;
                    c = false;
                }
                len++;
                c = true;
            }
            else if(alphabets[s.charAt(i) - 'a'] == false) {
                alphabets[s.charAt(i) - 'a'] = true;
                len++;
            }
            else {
                larlen = Math.max(larlen, len);
                len = 0;
                i--;
                alphabets = new boolean[26];
            }
        }
        larlen = Math.max(larlen, len);
        return larlen;
    }
    public static void main(String args[]) {
        String s = " ";
        System.out.print(lengthOfLongestSubstring(s));
    }
}