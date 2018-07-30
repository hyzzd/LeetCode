class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        
        if(nums.length < 3) return list;                  //edge cases
        Arrays.sort(nums);                                //promise not duplicate triples
        int target = 0;
        for(int i = 0; i < nums.length; ++i){
            if(i > 0 && nums[i] == nums[i - 1]) continue; //
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] < target){
                    j++;
                    while(nums[j] == nums[j - 1] && j < k) ++j;
                }
                else if(nums[i] + nums[j] + nums[k] > target){
                    k--;
                    while(nums[k] == nums[k + 1] && j < k) --k;
                }else{
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    --k;
                    while(nums[j] == nums[j - 1] && j < k) ++j;
                    while(nums[k] == nums[k + 1] && j < k) --k;
                }
            }            
        }        
        return list;
    }
}
// O(n^2)
// O(1)
