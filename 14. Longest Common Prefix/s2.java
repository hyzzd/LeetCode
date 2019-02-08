public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        return LCP(strs, 0, strs.length - 1);
    }

    private String LCP(String[] strs, int l, int r) {
        if (l == r)
            return strs[l];
        else {
            int mid = (l + r) / 2;
            String left = LCP(strs, l, mid);
            String right = LCP(strs, mid + 1, r);
            return commonPrefix(left, right);
        }
    }

    private String commonPrefix(String l, String r) {
        int min = Math.min(l.length(), r.length());
        for (int i = 0; i < min; ++i) {
            if (l.charAt(i) != r.charAt(i))
                return l.substring(0, i);
        }
        return l.substring(0, min);
    }
}
// O(s)
// O(mlgn)
