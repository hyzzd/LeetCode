class Solution {
    public boolean hasAlternatingBits(int n) {
        return ((n + (n >> 1) + 1) & (n + (n >> 1))) == 0;
    }
}
// O(1)
// O(1)
