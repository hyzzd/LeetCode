class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int ans = 0, res = prices[0];
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] < prices[i-1]){ // forgot to check the ending
                ans += prices[i-1] - res;
                res = prices[i];
            }
            if(i == prices.length-1){
                ans += prices[i] - res;
            }
        }
        return ans;
    }
}
// Don't forget to check the ending!
// O(n)
// O(1)
