class Solution {
    public int findComplement(int num) {
        //return ~num & ((Integer.highestOneBit(num) << 1) - 1);
        int i = 0, j = 0;
        while(i < num){
            i += Math.pow(2, j);
            j++;
        }
        return i - num;
    }
}
// using the complement is 11111111 minus num
// thus we just find the first 1111 larger than it
