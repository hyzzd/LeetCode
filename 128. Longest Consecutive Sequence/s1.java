class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for (int i : nums) {
            hashset.add(i);
        }

        int longest = 0;
        for (int i : nums) {
            int len = 1;
            for (int j = i - 1; hashset.contains(j); --j) {
                hashset.remove(j);
                len++;
            }
            for (int j = i + 1; hashset.contains(j); ++j) {
                hashset.remove(j);
                len++;
            }
            longest = Math.max(longest, len);
        }
        return longest;
    }
}
// O(n)
// O(n)
