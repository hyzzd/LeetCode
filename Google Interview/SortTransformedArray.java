class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return result;
        }
        int left = 0, right = nums.length - 1;
        int i = a >= 0 ? nums.length - 1 : 0;
        while (left <= right) {
            int l = a * nums[left] * nums[left] + b * nums[left] + c;
            int r = a * nums[right] * nums[right] + b * nums[right] + c;
            if (a >= 0) {
                if (l <= r) {
                    result[i--] = r;
                    right--;
                } else {
                    result[i--] = l;
                    left++;
                }
            } else {
                if (l > r) {
                    result[i++] = r;
                    right--;
                } else {
                    result[i++] = r;
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SortTransformedArray m = new SortTransformedArray();
        int[] nums = new int[] { -4, -2, 2, 4 };
        int[] result = m.sortTransformedArray(nums, 1, 3, 5);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}