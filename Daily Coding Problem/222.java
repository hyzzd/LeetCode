import java.util.*;

class Main {
    public static String path(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                stack.pop();
            } else {
                stack.push(dir);
            }
        }

        return String.join("/", stack);
    }

    public static void main(String[] args) {
        System.out.println(path("/usr/bin/../bin/./scripts/../"));
    }
}