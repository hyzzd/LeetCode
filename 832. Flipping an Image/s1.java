class Solution {
    public int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; ++i) {
            for (int l = 0, r = A[0].length - 1; l < r; ++l, --r) {
                int temp = A[i][l];
                A[i][l] = A[i][r];
                A[i][r] = temp;
            }
            for (int j = 0; j < A[0].length; ++j) {
                A[i][j] ^= 1;
            }
        }
        return A;
    }
}
