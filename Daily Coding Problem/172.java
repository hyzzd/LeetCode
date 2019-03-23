import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Main {
    class Tire {
        Tire root;
        Tire[] children;
        boolean isWord;

        Tire() {
            children = new Tire[26];
            isWord = false;
        }

        public void addWord(String s) {
            int len = s.length();

            Tire curr = root;
            for (int i = 0; i < len; i++) {
                if (curr.children[s.charAt(i) - 'a'] == null) {
                    curr.children[s.charAt(i) - 'a'] = new Tire();
                }

                curr = curr.children[s.charAt(i) - 'a'];
            }

            curr.isWord = true;
        }

        public boolean search(String s) {
            int len = s.length();
            Tire curr = root;
            for (int i = 0; i < len; i++) {
                if (curr.children[s.charAt(i) - 'a'] == null) {
                    return false;
                }

                curr = curr.children[s.charAt(i) - 'a'];
            }

            return curr != null && curr.isWord;
        }
    }

    public List<Integer> findConcat(String s, List<String> word) {
        List<String> res = new LinkedList<>();
        Tire root = new Tire();
        List<String> permuStr = permute(word, 0);
        for (int i = 0; i < permuStr.size(); i++) {
            root.addWord(permuStr.get(i));
        }

        int len = word.get(0).length() * word.size();
        for (int i = 0; i < s.length() - 1 - len; i++) {
            if (root.search(s.substring(i))) {
                res.add(s.substring(i, len));
            }
        }

        return res;
    }

    private List<String> permute(List<String> arr, int k) {
        List<String> res = new ArrayList<>();
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1);
            Collections.swap(arr, i, k);
        }
        if (k == arr.size() - 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = k; i < arr.size(); i++) {
                sb.append(arr.get(i));
            }
            res.add(sb.toString());
        }

        return res;
    }
}