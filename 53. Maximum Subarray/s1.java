class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max + nums[i], nums[i]);
            sum = Math.max(sum, max); 
        }
        return sum;
    }
}
// DP
// O(n)
// O(1)
