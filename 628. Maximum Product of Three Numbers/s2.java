class Solution {
    public int maximumProduct(int[] nums) {
        int[] ans = new int[5];
        int n = nums.length;
        ans[0] = Integer.MAX_VALUE;
        ans[1] = Integer.MAX_VALUE;
        ans[2] = Integer.MIN_VALUE;
        ans[3] = Integer.MIN_VALUE;
        ans[4] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= ans[0]) {
                ans[1] = ans[0];
                ans[0] = nums[i];
            } else if (nums[i] <= ans[1]) {
                ans[1] = nums[i];
            }
            if (nums[i] >= ans[4]) {
                ans[2] = ans[3];
                ans[3] = ans[4];
                ans[4] = nums[i];
            } else if (nums[i] >= ans[3]) {
                ans[2] = ans[3];
                ans[3] = nums[i];
            } else if (nums[i] >= ans[2]) {
                ans[2] = nums[i];
            }
        }
        return Math.max(ans[0] * ans[1] * ans[4], ans[2] * ans[3] * ans[4]);
    }
}
// O(n)
// O(1)
