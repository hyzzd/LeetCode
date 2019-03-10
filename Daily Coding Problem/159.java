import java.util.Set;

class Main {
    public static char firstRecurringChar(String s) {
        if (s == null || s.length == 0) {
            return null;
        }
        Set<Character> set = new HashSet();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                return ch;
            } else {
                set.add(ch);
            }
        }
    }
}