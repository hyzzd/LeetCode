class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int j = 0;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == ' ' && j > 0) return j;
            else if(s.charAt(i) != ' ') j++;
        }
        return j;
    }
}
