class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] ans = new int[n];
        int p = Integer.MIN_VALUE / 2;
        for(int i = 0; i < n; ++i){
            if(S.charAt(i) == C) p = i;
            ans[i] = i - p;
        }
        p = Integer.MAX_VALUE / 2;
        for(int i = n-1; i >= 0; --i){
            if(S.charAt(i) == C) p = i;
            ans[i] = Math.min(ans[i], p - i);
        }
        return ans;
    }
}
// the shortest distance is the min of left and right dist
// first for loop gives the dist to left chars
// second for loop gives the dist to right chars
// take min of them
// O(N)
// O(N)
