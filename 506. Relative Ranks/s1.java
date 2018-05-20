class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] ans = new String[nums.length];
        int max = 0;
        for(int i: nums) max = Math.max(max, i);
        int[] hash = new int[max+1];
        for(int i = 0; i < nums.length; ++i) hash[nums[i]] = i+1;
        int k = 0;
        for(int i = hash.length-1; i >= 0; --i){
            if(hash[i] != 0){
                if(k == 0) ans[hash[i] - 1] = "Gold Medal";
                else if(k == 1) ans[hash[i] - 1] = "Silver Medal";
                else if(k == 2) ans[hash[i] - 1] = "Bronze Medal";
                else ans[hash[i] - 1] = String.valueOf(k + 1);    
                k++;
            }
        }
        return ans;
    }
}
// O(n)
// O(1)
