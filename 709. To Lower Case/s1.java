class Solution {
    public String toLowerCase(String str) {
        StringBuilder s = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c - 'A' >= 0 && c - 'A' <= 26) s.append((char)(c - 'A' + 'a'));
            else s.append(c);
        }
        return s.toString();
    }
}
// O(n)
// O(1)
