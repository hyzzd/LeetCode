class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        while (xor != 0) {
            xor &= xor - 1;
            ++count;
        }
        return count;
    }
}
// xor & (xor - 1) will eliminate the last 1 bit in a integer
// better than s1
