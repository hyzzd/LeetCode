class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums2.length; ++i) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; ++i) {
            int index = map.get(nums1[i]);
            int minIndex = -1;
            while (++index < nums2.length) {
                if (nums2[index] > nums1[i]) {
                    minIndex = index;
                    break;
                }
            }
            if (minIndex == -1)
                ans[i] = -1;
            else
                ans[i] = nums2[index];
        }
        return ans;
    }
}
// O(nm) n and m are two length
// O(n+m)
