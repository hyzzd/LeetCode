class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int l = 0; l < s.length(); l += 2 * k) {
            int i = l, j = Math.min(l + k - 1, s.length() - 1);
            while (i < j) {
                char temp = c[i];
                c[i++] = c[j];
                c[j--] = temp;
            }
        }
        return new String(c);
    }
}
// O(n)
// O(n)
