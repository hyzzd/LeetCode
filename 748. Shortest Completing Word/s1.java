class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String target = licensePlate.toLowerCase();
        int[] charMap = new int[26];
        for (int i = 0; i < licensePlate.length(); ++i) {
            if (Character.isLetter(target.charAt(i)))
                charMap[target.charAt(i) - 'a']++;
        }
        String result = null;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; ++i) {
            String word = words[i].toLowerCase();
            if (isMatch(charMap, word) && minLength > word.length()) {
                minLength = word.length();
                result = words[i];
            }
        }
        return result;
    }

    private boolean isMatch(int[] charMap, String word) {
        int[] wordMap = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            if (Character.isLetter(word.charAt(i)))
                wordMap[word.charAt(i) - 'a']++;
        }
        for (int i = 0; i < charMap.length; ++i) {
            if (charMap[i] > wordMap[i])
                return false;
        }
        return true;
    }
}
