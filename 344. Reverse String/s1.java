public class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
// using the buildin method
// String class does not have reverse()
// O(n)
// O(n)
