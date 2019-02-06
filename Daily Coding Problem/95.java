class Main {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }

        if (i != 0) {
            int x = nums.length - 1;
            for (; x >= i; x--) {
                if (nums[x] > nums[i - 1]) {
                    break;
                }
            }

            swap(nums, i - 1, x);
        }

        reverse(nums, i, nums.length - 1);
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    void reverse(int[] a, int i, int j) {
        for (; i < j; i++, j--) {
            swap(a, i, j);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}