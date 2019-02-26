class Solution {
    public int countSegments(String s) {
        String str = s.trim();
        if (str.length() == 0)
            return 0;
        return str.split("\\s+").length;
    }
}
// O(n)
// O(n)
