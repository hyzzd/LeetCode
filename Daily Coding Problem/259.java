import java.util.*;

class Main {
    public Set<Character> getOptimalChars(String[] words) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (String word : words) {
            char fc = word.charAt(0);
            if (!map.containsKey(fc)) {
                map.put(fc, new HashSet<>());
            }
            map.get(fc).add(word.length());
        }

        Set<Character> optChars = new HashSet<>();
        for (char c : map.keySet()) {
            Set<Integer> set = map.get(c);
            boolean flag = false;
            for (int i : set) {
                if (i % 2 == 1) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                optChars.add(c);
            }
        }

        return optChars;
    }
}