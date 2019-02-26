public class Solution {
    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1)
            return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}
// O(nlgn) T(n) = 2 * T(n/2) + O(n)
// O(lgn) depth of the recursive tree*O(1) see note
