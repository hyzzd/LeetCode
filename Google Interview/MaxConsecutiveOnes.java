class Main {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0, curr = 0;
        for (int i : nums) {
            if (i != 1) {
                res = Math.max(res, curr);
                curr = 0;
            } else {
                curr++;
            }
        }
        res = Math.max(res, curr);
        return res;
    }

    public static void main(String args[]) {
        Main m = new Main();
        int[] nums = new int[] { 1, 1, 0, 1, 1, 1 };
        System.out.print(m.findMaxConsecutiveOnes(nums));
    }
}