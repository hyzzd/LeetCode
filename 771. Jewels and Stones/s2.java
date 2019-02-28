class Solution {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int result = 0;
        for (char ch : J.toCharArray()) {
            map.put(ch, 1);
        }
        for (char ch : S.toCharArray()) {
            if (map.containsKey(ch))
                ++result;
        }
        return result;
    }
}
// hashmap
// O(J+S) two loops
// O(J+S)
