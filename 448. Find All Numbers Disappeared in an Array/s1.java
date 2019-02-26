class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i)
            nums[(nums[i] - 1) % nums.length] += nums.length;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= nums.length)
                list.add(i + 1);
        }
        return list;
    }
}
// O(n)
// O(n)
