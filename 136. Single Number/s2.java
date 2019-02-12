class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            ans ^= nums[i];
        }
        return ans;
    }
}
// so clever method!!
// bit manipulation is usually a choice for no extra space
// O(n)
// O(1)
