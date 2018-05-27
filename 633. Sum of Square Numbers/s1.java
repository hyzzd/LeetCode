class Solution {
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a*a <= c; ++a){
            double b = Math.sqrt(c - a*a);
            if(b == (int) b) return true;
        }
        return false;
    }
}
// O(sqrt(c)lgc) we iterate over values. And for each value, O(lgc) are cost to find the sqrt root
// O(1)
