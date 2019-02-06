import java.util.Stack;

class Main {
    Stack<String> stack = new Stack<>();
    static int count = 0;

    public void record(String id) {
        stack.push(id);
        count++;
    }

    public String getLast(int i) {
        if (i > count) {
            return "Error";
        }

        int num = 0;
        Stack<String> temp = new Stack<>();

        while (num < i - 1) {
            String str = stack.pop();
            temp.push(str);
            num++;
        }
        String result = stack.peek();
        while (!temp.empty()) {
            String str = temp.pop();
            stack.push(str);
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.record("1");
        m.record("2");
        m.record("3");
        m.record("4");
        m.record("5");

        System.out.println(m.getLast(2));
    }
}