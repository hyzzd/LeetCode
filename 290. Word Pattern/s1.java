class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split("\\s+");
        if (pattern.length() != words.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i]))
                    return false;
            } else {
                if (map.containsValue(words[i]))
                    return false;
                map.put(c, words[i]);
            }
        }
        return true;
    }
}
// O(n)
// O(n)
