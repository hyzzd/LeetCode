import java.util.Arrays;

class Main {
    public static int calc(char[] arr) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : arr) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (stack.size() < 2) {
                    stack.push(ch);
                } else {
                    int val2 = Character.getNumericValue(stack.pop());
                    int val1 = Character.getNumericValue(stack.pop());
                    int val3 = calValue(val1, val2, ch);
                    stack.push(val3);
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.pop();
    }

    private static int calValue(int a, int b, char ch) {
        int res = 0;
        switch (ch) {
        case '+':
            res = a + b;
            break;
        case '-':
            res = a - b;
            break;
        case '*':
            res = a * b;
            break;
        case '/':
            res = a / b;
            break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(calc(new char[] { 5, 7, 1, 1, '+', '-', '/', 3, '*', 2, 1, 1, '+', '+', '-' }));
    }
}