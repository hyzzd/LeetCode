class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int mingap = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int gap = Math.abs(target - sum);
                if (gap < mingap) {
                    result = sum;
                    mingap = gap;
                }

                if (sum < target)
                    ++j;
                else
                    --k;
            }
        }
        return result;
    }
}
// O(n^2)
// O(1)
