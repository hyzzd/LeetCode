import java.util.Arrays;

class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        ThreeSumSmaller m = new ThreeSumSmaller();
        int[] nums = new int[] { -2, 0, 1, 3 };
        System.out.print(m.threeSumSmaller(nums, 2));
    }
}