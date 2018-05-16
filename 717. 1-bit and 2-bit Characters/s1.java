class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        for(int i = 0; i < bits.length; ++i){
            if(bits[i] == 1){
                ++i;
                index = 2;
            }
            else{
                index = 1;
            }
        }
        return index == 1 ? true : false;
    }
}
// O(n)
// O(1)
