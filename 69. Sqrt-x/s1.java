// newton method
class Solution {
    public int mySqrt(int x) {
        long r = x;
        while(r * r > x){
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}

/* binary search
class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        int left = 0; right = Integer.MAX_VALUE;
        while(true){
            int mid = (left + right) / 2;
            if(mid * mid > x) right = mid - 1;
            else{
                if((mid + 1) * (mid + 1) > x)
                    return mid;
                left = mid + 1;
            }
        }
    }
}
*/
