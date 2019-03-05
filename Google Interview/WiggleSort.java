class Main {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                int temp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String args[]) {
        Main m = new Main();
        int[] nums = new int[] { 3, 5, 2, 1, 6, 4 };
        m.wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}