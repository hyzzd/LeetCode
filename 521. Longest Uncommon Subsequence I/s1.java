class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
}
// this problem has an issue that
// abcabc does not contain subseq with abcabd
// O(min(a, b)) equals method
// O(1)
