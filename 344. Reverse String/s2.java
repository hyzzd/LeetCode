// I forgot to check the edge conditions
// when s="" or s is null
public class Solution {
    public String reverseString(String s) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = new char[ch1.length];
        for (int i = 0; i < ch1.length; i++){
            ch2[ch1.length - i - 1] = ch1[i];
        }
        return String.valueOf(ch2);
    }
}
// Converting String to character array
// O(n)
// O(n)
