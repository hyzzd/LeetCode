class Solution {
    public int addDigits(int num) {
        if (num < 10 && num >= 0)
            return num;

        int i = 0;
        while (num > 0) {
            i += num % 10;
            num /= 10;
        }
        return addDigits(i);
    }
}
// O(n)
// O(1)
