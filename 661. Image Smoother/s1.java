class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] ans = new int[M.length][M[0].length];
        for(int i = 0; i < M.length; ++i){
            for(int j = 0; j < M[0].length; ++j){
                int count = 0;
                for(int a: new int[]{-1, 0, 1}){
                    for(int b: new int[]{-1, 0, 1}){
                        if(i+a>=0 && i+a<M.length && j+b>=0 && j+b<M[0].length){
                            ans[i][j]+=M[i+a][j+b];
                            count++;
                        }
                    }
                }
                ans[i][j] /= count;
            }
        }
        return ans;
    }
}
// O(n)
// O(n)
