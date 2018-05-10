class Solution {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
// bit manipulation
// remember that 010 flips get 11111101, so we need to ignore the first 5 bits
// O(1)
// O(1)
