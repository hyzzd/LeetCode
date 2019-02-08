public class Solution {
    public boolean isPalindrome(int x) { // Cannot solve it without using extra space
        int sum = 0, target = x;
        while (x > 0) {
            int temp = x % 10;
            x /= 10;
            sum = sum * 10 + temp;
        }
        return sum == target;
    }
}
