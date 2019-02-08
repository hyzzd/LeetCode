class Main {
    public int[] rotateArr(int[] arr, int n) {
        int[] result = new int[arr.length];
        result = swapArr(arr, 0, n - 1);
        result = swapArr(result, n, arr.length - 1);
        result = swapArr(result, 0, arr.length - 1);
        return result;
    }

    private int[] swapArr(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
        return arr;
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
        nums = m.rotateArr(nums, 2);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }
}