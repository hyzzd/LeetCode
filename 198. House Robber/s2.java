class Solution {
    public int rob(int[] nums) {
        int y = 0;
        int n = 0;
        for(int i:nums){
            int t = n;
            n = Math.max(y, n);
            y = t + i;
        }
        return Math.max(n, y);
    }
}
// O(n)
// O(1)
