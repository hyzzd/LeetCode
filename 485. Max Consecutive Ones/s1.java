class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for(int i = 0; i < nums.length; ++i){
            max = Math.max(max, count = nums[i] == 0 ? 0 : count + 1);
        }
        return max;
    }
}
// O(n)
// O(1)
