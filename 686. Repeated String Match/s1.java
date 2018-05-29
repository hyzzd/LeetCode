class Solution {
    public int repeatedStringMatch(String A, String B) {
        int ans = 1;
        StringBuilder S = new StringBuilder(A);
        for(; S.length() < B.length(); ++ans){
            S.append(A);
        }
        if(S.indexOf(B) >= 0) return ans;
        if(S.append(A).indexOf(B) >= 0) return ans + 1;
        return -1;
    }
}
// O(n*(m+n))
// O(m+n)
