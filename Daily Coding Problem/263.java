import java.util.*;

class Main {
    private final Set<Character> SEPARATORS = new HashSet<>(Arrays.asList(',', ';', ':'));
    private final Set<Character> TERM_MARKS = new HashSet<>(Arrays.asList('.', '?', '!'));

    public boolean isValid(String s) {
        return isValidUtil("", s.charAt(0), s.substring(1));
    }

    private boolean isValidUtil(String context, char c, String next) {
        if (context != null && !context.isEmpty() && Character.isLowerCase(c))
            return false;

        if (context.length() == 1) {
            if (c != ' ' && !Character.isLowerCase(c)) {
                return false;
            }
        }

        if (TERM_MARKS.contains(c)) {
            char last = context.charAt(context.length() - 1);
            return (!SEPARATORS.contains(last) || !TERM_MARKS.contains(last));
        }

        if (next != null && !next.isEmpty()) {
            return (TERM_MARKS.contains(c));
        }

        return isValidUtil(context + c, next.charAt(0), next.substring(1));
    }
}