class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length < 1) return 0;
        int ans = 1, start = 0;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] <= nums[i - 1]){
                if(ans < i - start){
                    ans = i - start;
                }
                start = i;
            }
        }
        return Math.max(ans, nums.length - start);
    }
}
// O(n)
// O(1)
