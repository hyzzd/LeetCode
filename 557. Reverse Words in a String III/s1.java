class Solution {
    public String reverseWords(String s) {
        String[] str = s.split("\\s+");
        StringBuilder string = new StringBuilder();
        for(String st: str){
            char[] char1 = st.toCharArray();
            char[] char2 = new char[char1.length];
            for(int i = 0; i < char1.length; ++i){
                char2[i] = char1[char1.length - i - 1];
            }
            if(string.length() != 0) string.append(" ");
            string.append(new String(char2));
        }
        
        return string.toString();
    }
}
// naive
// O(mn) m is the word length, n is the length of words
// O(N) max length of string
