class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two pointers method
        int i = m;
        int j = n;

        while (i >= 1 && j >= 1) {
            if (nums1[i - 1] >= nums2[j - 1]) {
                nums1[i + j - 1] = nums1[i - 1];
                i--;
            } else {
                nums1[i + j - 1] = nums2[j - 1];
                j--;
            }
        }
        while (j >= 1) {
            nums1[i + j - 1] = nums2[j - 1];
            j--;
        }
    }
}
