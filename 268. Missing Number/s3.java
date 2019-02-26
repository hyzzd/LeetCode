class Solution {
    public int missingNumber(int[] nums) {
        long ans = 0;
        for (long i : nums)
            ans ^= ((long) 1 << i);
        int index = 0;
        while (ans > 0) {
            if (ans % 2 == 0) {
                break;
            }
            ans /= 2;
            index++;
        }
        return index;
    }
}
// This method limits by the long is 2^64. Thus the nums arrays should be
// shorter than 64.
