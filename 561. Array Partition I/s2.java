class Solution {
    public int arrayPairSum(int[] nums) {
        /*
        Arrays.sort(nums);
        int result = 0;
        for(int i = 0; i < nums.length; ++i){
            if(i % 2 == 0) result += nums[i];
        }
        return result;
        */
        // counting sort
        int result = 0;
        int[] count = new int[20001]; // -10000~0~10000
        for(int i = 0; i < nums.length; ++i)
            count[nums[i] + 10000]++;
        boolean sgn = true;
        for(int i = 0; i < count.length; ++i){
            while(count[i] != 0){
                if(sgn){
                    result += i - 10000;
                }
                sgn = !sgn;
                count[i]--;
            }
        }
        return result;
    }
}
// counting sort idea
// O(n+m)
// O(N)
