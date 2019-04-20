import java.util.*;

class Main {
    public static String parentheses(String s) {
        int isopen = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (isopen == 0 && ch == ')')
                continue;
            if (ch == '(') {
                sb.append(ch);
                isopen++;
            } else if (ch == ')') {
                sb.append(ch);
                isopen--;
            }
        }

        while (isopen-- > 0) {
            sb.append(')');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(parentheses("(()"));
        System.out.println(parentheses("))()("));
    }
}