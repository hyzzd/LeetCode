public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                results[1] = i;
                results[0] = map.get(target - nums[i]);
                return results;
            }
            map.put(nums[i], i);
        }
        return results;
    }
}
// One pass hash table
// O(n)
// O(n)
