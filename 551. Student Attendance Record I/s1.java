class Solution {
    public boolean checkRecord(String s) {
        if(s.indexOf('A') != s.lastIndexOf('A') || s.contains("LLL"))
            return false;
        return true;
    }
}
// The complexity of Java's implementation of indexOf is O(m*n) where n and m are the length of the search string and pattern respectively
// The complexity of Java's implementation of contains is O(n)
