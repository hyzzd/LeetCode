class Solution {
    public int[][] transpose(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int[][] B = new int[c][r];
        for(int i = 0; i < r; ++i){
            for(int j = 0; j < c; ++j){
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
// O(mn)
// O(mn)
