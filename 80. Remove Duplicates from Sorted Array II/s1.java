class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int i = 0;
        for(int j = 2;j < nums.length;j++)
        {
            if(nums[j] != nums[i])
            {
                i++;
                nums[i+1] = nums[j];
            }
        }
        return i+2;
    }
}
