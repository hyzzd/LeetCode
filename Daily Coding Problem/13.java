import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Main {
    public String longestSubstr(String s, int k) {
        if (s == null || s.length() == 0 || s.length() <= k)
            return s;

        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        Queue<Character> q = new LinkedList<Character>();
        int start = 0, startIdx = 0, maxLen = 0;

        for (int i = 0; i < ch.length; ++i) {
            if (set.size() < k) {
                set.add(ch[i]);
                q.add(ch[i]);
            }
            // size == k
            else if (!set.contains(ch[i])) {
                int temp = start;
                while (q.contains(ch[temp])) {
                    q.remove();
                    start++;
                }

                set.remove(ch[temp]);
                set.add(ch[i]);
                q.add(ch[i]);
            } else {
                q.add(ch[i]);
            }

            if (i - start + 1 > maxLen) {
                maxLen = i - start + 1;
                startIdx = start;
            }
        }

        return s.substring(startIdx, startIdx + maxLen);
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.longestSubstr("abbbcbca", 2));
    }
}