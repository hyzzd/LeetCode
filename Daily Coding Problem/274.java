import java.util.*;

class Main {
    public int parseStr(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int res = 0, sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += sign * sum;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            }
        }
        return res;
    }
}