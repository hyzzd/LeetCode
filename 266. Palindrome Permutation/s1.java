class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] a = new int[128];
        for(char c:s.toCharArray()){
            a[c]++;
        }
        int ans = 0;
        for(int i = 0; i < a.length; ++i){
            if(a[i] % 2 == 1) ans++;
        }
        return ans > 1 ? false : true;
    }
}
// O(n)
// O(1)
