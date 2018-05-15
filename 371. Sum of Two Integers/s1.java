class Solution {
    public int getSum(int a, int b) {
        int c = 0;
        c += a ^ b;
        c += (a & b) << 1;
        return c;
    }
}
