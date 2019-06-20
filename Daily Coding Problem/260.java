class Main {
    public int[] decode(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '+')
                count++;
        }

        int first = n - count - 1;
        nums[0] = first;
        int small = first - 1, large = first + 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == '+') {
                nums[i] = large;
                large++;
            } else {
                nums[i] = small;
                small--;
            }
        }

        return nums;
    }
}
