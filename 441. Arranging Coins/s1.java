class Solution {
    public int arrangeCoins(int n) {
        long l = 0;
        long r = n;
        while(l<=r){
            long mid = (l+r)/2;
            long res = mid*(mid+1)/2;
            if(res == (long)n) return (int)mid;
            else if(res < (long)n) l = mid + 1;
            else r = mid - 1;            
        }
        return (int) (l+r)/2;
    }
}
// O(lgn)
// O(1)
