class Solution {
    public int firstUniqChar(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            num[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (num[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
// O(n)
// O(1)
