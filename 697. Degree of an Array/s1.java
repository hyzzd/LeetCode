class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(left.get(nums[i]) == null) left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        int ans = nums.length;
        int degree = Collections.max(count.values());
        for(int i: count.keySet()){
            if(count.get(i) == degree){
                ans = Math.min(ans, right.get(i) - left.get(i) + 1);
            }
        }
        return ans;
    }
}
// O(n)
// O(n)
