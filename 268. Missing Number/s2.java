class Solution {
    public int missingNumber(int[] nums) {
        int ans = nums.length;
        for(int i = 0; i < nums.length; ++i){
            ans ^= i ^ nums[i];
        }        
        return ans;
    }
}
// O(n)
// O(1)
// if we initialize an integer to nn and XOR it with every index and value, we will be left with the missing number.
