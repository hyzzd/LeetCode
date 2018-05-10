class Solution {
    public int distributeCandies(int[] candies) {
        // first loop over see how many kinds
        // sister get all kinds, if not in order
        int[] a = new int[candies.length];
        for(int i = 0; i < candies.length; ++i){
            a[candies[i]]++;
        }
        int count = 0;
        for(int i = 0; i < a.length; ++i){
            if(a[i] != 0) count++;
        }
        return Math.min(candies.length / 2, count);
    }
}
// not very good, much assume the candies are sorted
// or O(nlgn)
