class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int value = update[2];
            res[start] += value;
            if (end < length - 1) {
                res[end + 1] -= value;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }

    public static void main(String args[]) {
        RangeAddition m = new RangeAddition();
        int[][] updates = new int[][] { { 1, 3, 2 }, { 2, 3, 3 } };
        int[] nums = m.getModifiedArray(5, updates);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}