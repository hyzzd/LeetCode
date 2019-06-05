import java.util.*;

class Main {
    public static boolean canFormCircle(List<String> words) {
        Set<String> wordSet = new HashSet<>(words);
        Map<Character, HashSet<String>> wordDict = createWordDict(words);
        for (String word : words) {
            char ch = word.charAt(word.length() - 1);
            wordSet.remove(word);
            if (dfs(ch, wordSet, Arrays.asList(word), wordDict)) {
                return true;
            }
            wordSet.add(word);
        }

        return false;
    }

    public static boolean dfs(char curr, Set<String> remaining, List<String> seen,
            Map<Character, HashSet<String>> wordDict) {
        if (remaining.isEmpty() && curr == seen.get(0).charAt(0)) {
            System.out.println(seen);
            return true;
        }

        if (!wordDict.containsKey(curr) || wordDict.get(curr).isEmpty()) {
            return false;
        }

        Set<String> nextWords = wordDict.get(curr).clone();
        for (String nextWord : nextWords) {
            Map<Character, HashSet<String>> wordDictCp = new HashMap<>(wordDict);
            Set<String> remainingCp = new HashSet<>(remaining);
            List<String> seenCp = new ArrayList<>(seen);
            wordDictCp.get(curr).remove(nextWord);
            remainingCp.remove(nextWord);
            seenCp.add(nextWord);
            if (dfs(nextWord.charAt(nextWord.length() - 1), remainingCp, seenCp, wordDictCp)) {
                return true;
            }
        }

        return false;
    }

    public static Map<Character, HashSet<String>> createWordDict(List<String> words) {
        Map<Character, HashSet<String>> wordDict = new HashMap<>();
        for (String word : words) {
            char ch = word.charAt(0);
            if (!wordDict.containsKey(ch)) {
                wordDict.put(ch, new HashSet<>());
            }
            wordDict.get(ch).add(word);
        }
        return wordDict;
    }
}