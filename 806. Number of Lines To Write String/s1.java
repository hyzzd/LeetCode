class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int line = 1, offset = 0;
        for (char c : S.toCharArray()) {
            int w = widths[c - 'a'];
            offset += w;
            if (offset > 100) {
                line++;
                offset = w;
            }
        }
        return new int[] { line, offset };
    }
}
// O(n) string length
// O(1)
