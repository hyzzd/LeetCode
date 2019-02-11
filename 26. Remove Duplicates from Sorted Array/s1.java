public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int i = 1;
        int j = 0;
        while (i < nums.length) {
            if (nums[i] == nums[j]) {
                i++;
            } else {
                j++;
                nums[j] = nums[i];
                i++;
            }
        }
        return j + 1;
    }
}

/*
 * int count = 0; for (int i = 0; i < A.length - 1; i++) { if (A[i] == A[i + 1])
 * { count++; } } return (A.length - count);
 */
