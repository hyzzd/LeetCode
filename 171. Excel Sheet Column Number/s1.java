class Solution {
    public int titleToNumber(String s) {
        int[] word = new int[26];
        for(int i=0; i<word.length; ++i) word[i] = i+1;
        int ans = 0;
        for(char c: s.toCharArray()) ans = ans*26+word[c-'A'];
        return ans;
    }
}
// O(n)
// O(1)
