class Solution {
    public int longestPalindrome(String s) {
        int[] n = new int[128];
        for(char c: s.toCharArray()){
            n[c]++;
        }
        int ans = 0;
        for(int i = 0; i < n.length; ++i){
            if(ans % 2 == 0 && n[i] % 2 == 1){
                ans++;
            }
            ans += n[i] / 2 * 2;
        }
        return ans;
    }
}
// O(n)
// O(n)
