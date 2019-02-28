class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] str = paragraph.toLowerCase().split("[ !?',;.]+");
        Map<String, Integer> map = new HashMap<>();
        for (String s : str) {
            if (map.get(s) == null)
                map.put(s, 1);
            else
                map.put(s, map.get(s) + 1);
        }
        for (String b : banned) {
            if (map.get(b) != null)
                map.remove(b);
        }
        String ans = null;
        for (String c : map.keySet()) {
            if (ans == null || map.get(c) > map.get(ans))
                ans = c;
        }
        return ans;
    }
}
// O(p+b)
// O(p+b)
