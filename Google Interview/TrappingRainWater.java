class TrappingRainWater {
    public int trap(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int i = 0, j = A.length - 1;
        int max = 0;
        int lmax = 0;
        int rmax = 0;
        while (i <= j) {
            lmax = Math.max(lmax, A[i]);
            rmax = Math.max(rmax, A[j]);
            if (lmax < rmax) {
                max += lmax - A[i];
                i++;
            } else {
                max += rmax - A[j];
                j--;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        TrappingRainWater m = new TrappingRainWater();
        int[] nums = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.print(m.trap(nums));
    }
}