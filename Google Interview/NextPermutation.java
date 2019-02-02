class Main {
    public void nextPermutation(int[] nums) {
        // find two adjacent elements, n[i-1] < n[i]
        int i = nums.length - 1;
        for (; i > 0; i --) {
            if (nums[i] > nums[i-1]) {
                break;
            }
        }
        if (i != 0) {
            // swap (i-1, x), where x is index of the smallest number in [i, n)
            int x = nums.length - 1;
            for (; x >= i; x --) {
                if (nums[x] > nums[i-1]) {
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
    // reverse a[i, j]
    void reverse(int[] a, int i, int j) {
        for (; i < j; i ++, j --) {
            swap(a, i, j);
        }
    }
    public static void main(String[] args){
        Main s = new Main();
        int[] nums = new int[]{1,2,3,4};
        s.nextPermutation(nums);
        for(int num : nums){
            System.out.print(num + " ");
        }        
    }
}