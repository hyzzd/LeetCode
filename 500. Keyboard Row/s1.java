// remember to check empty string
class Solution {
    public String[] findWords(String[] words) {
        String[] strings = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        Map<Character, Integer> set = new HashMap<>();
        for (int i = 0; i < strings.length; ++i) {
            for (char ch : strings[i].toCharArray()) {
                set.put(ch, i);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word == "")
                continue;
            int index = set.get(word.toLowerCase().charAt(0));
            for (char ch : word.toLowerCase().toCharArray()) {
                if (set.get(ch) != index) {
                    index = -1;
                    break;
                }
            }
            if (index != -1)
                ans.add(word);
        }
        return ans.toArray(new String[0]);
    }
}
// O(n)
// O(n)
