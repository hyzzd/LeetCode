public class Solution {
    public String reverseString(String s) {
        /*
        char[] ch1 = s.toCharArray();
        char[] ch2 = new char[ch1.length];
        for (int i = 0; i < ch1.length; i++){
            ch2[ch1.length - i - 1] = ch1[i];
        }
        return String.valueOf(ch2);
        */
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }
}
// 
// O(nlgn) T(n) = 2 * T(n/2) + O(n)
// O(lgn) depth of the recursive tree*O(1) see note
