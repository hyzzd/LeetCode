class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] s1 = new int[128];
        int[] s2 = new int[128];
        for(int i = 0; i < s.length(); ++i){
            if(s1[s.charAt(i)] != s2[t.charAt(i)]) return false;
            s1[s.charAt(i)] = i + 1;
            s2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
// O(n)
// O(1)
