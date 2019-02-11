class Solution {
    public void nextPermutation(int[] nums) {

        int index = -1;
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int digit = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] > nums[index]) {
                digit = i;
                break;
            }
        }
        swap(nums, index, digit);
        reverse(nums, index + 1, nums.length - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}
// O(n)
// O(1)
