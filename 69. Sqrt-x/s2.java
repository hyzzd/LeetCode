// binary search
class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        long left = 1, right = x;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x || (mid * mid < x && (mid + 1) * (mid + 1) > x))
                return (int) mid;
            else if (mid * mid > x)
                right = mid;
            else
                left = mid;
        }
        return 0;
    }
}
