class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String Morse[] = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };
        Set<String> code = new HashSet();
        for (String word : words) {
            StringBuilder str = new StringBuilder();
            for (char ch : word.toCharArray()) {
                str.append(Morse[ch - 'a']);
            }
            code.add(str.toString());
        }
        return code.size();
    }
}
// using HashSet, set size
// O(mn)
// O(m+n)
