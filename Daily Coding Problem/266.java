import java.util.*;

class Main {
    public List<String> getStepWords(String word, List<String> dict) {
        // assume all the words in dict are 1 letter longer than word, otherwise it
        // won't satisfy the rule
        List<String> res = new ArrayList<>();
        for (String s : dict) {
            if (checkAna(word, s))
                res.add(s);
        }
        return res;
    }

    public boolean checkAna(String s, String t) {
        int[] ch = new int[26];
        for (char c : t.toCharArray()) {
            ch[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            ch[c - 'a']--;
        }

        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (ch[i] != 0 && flag) {
                return false;
            }
            if (ch[i] == 1 && !flag) {
                flag = true;
            }
        }

        return flag;
    }
}