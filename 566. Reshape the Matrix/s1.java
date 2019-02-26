class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (r * c != row * col)
            return nums;

        int[][] newnum = new int[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                newnum[i][j] = nums[(i * c + j) / col][(i * c + j) % col];
            }
        }
        return newnum;
    }
}
// O(mn)
// O(mn)
