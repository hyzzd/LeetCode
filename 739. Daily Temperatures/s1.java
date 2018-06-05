class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; ++i){
            for(int j = i; j < temperatures.length; ++j){
                if(temperatures[j] > temperatures[i]){
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}
// O(n^2)
// O(n)
