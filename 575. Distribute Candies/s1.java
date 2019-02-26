class Solution {
    public int distributeCandies(int[] candies) {
        // first loop over see how many kinds
        // sister get all kinds, if not in order
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < candies.length; ++i) {
            if (map.get(candies[i]) != null) {
                map.put(candies[i], map.get(candies[i]) + 1);
            } else
                map.put(candies[i], 1);
        }
        int index = map.keySet().size();
        if (index >= candies.length / 2)
            return candies.length / 2;
        else
            return index;
    }
}
// O(n)
// O(n)
