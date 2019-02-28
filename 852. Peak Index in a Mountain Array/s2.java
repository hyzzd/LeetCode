class Solution {
    public int peakIndexInMountainArray(int[] A) {
        // binary search
        int ans = 0, l = 0, r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] < A[m - 1] && A[m] > A[m + 1]) {
                r = m - 1;
            } else if (A[m] > A[m - 1] && A[m] < A[m + 1])
                l = m + 1;
            else {
                ans = m;
                break;
            }
        }
        return ans;
    }
}
// O(lgn)
