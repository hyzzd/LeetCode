class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
// “abcdeabcde” (A + A)
// “cdeab” (B)
// O(n^2)
// O(n)
