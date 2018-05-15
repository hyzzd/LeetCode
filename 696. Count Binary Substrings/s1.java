class Solution {
    public int countBinarySubstrings(String s) {
        if(s.length() == 1) return 0;
        int ans = 0;
        int prev = 0, curr = 1;
        for(int i = 1; i < s.length(); ++i){
            if(s.charAt(i) == s.charAt(i - 1)){
                curr++;
            }else{
                prev = curr;
                curr = 1;           
            }
            if(prev >= curr) ans++;
        }        
        return ans;
    }
}
// O(n)
// O(1)
