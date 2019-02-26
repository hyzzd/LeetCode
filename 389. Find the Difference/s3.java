class Solution {
    public char findTheDifference(String s, String t) {
        int ch = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); ++i) {
            ch ^= t.charAt(i);
            ch ^= s.charAt(i);
        }
        return (char) ch;
    }
}
// similar as s2
