import java.util.*;

class Main {

    // 1 2 3 4 5 > 1 5 2 4 3
    // | 5 4 3 2 1 - push to q
    // | 1 5 4 3 2 - rotate last
    // 1 | 5 4 3 2 - poll
    // 1 5 | 4 3 2 - poll
    // 1 5 | 2 4 3 - rotate last
    // 1 5 2 | 4 3 - poll
    // 1 5 2 4 | 3 - poll...

    // push whole stack to queue, rotate q.size() - 1, poll() two times

    // 1 2 3 4 5 6 7 8 > 1 8 2 7 3 6 4 5
    // | 8 7 6 5 4 3 2 1 - push to q
    // | 1 8 7 6 5 4 3 2 - rotate last
    // 1 | 8 7 6 5 4 3 2 - poll
    // 1 8 | 7 6 5 4 3 2 - poll
    // 1 8 | 2 7 6 5 4 3 - rotate last
    // 1 8 2 | 7 6 5 4 3 - poll
    // 1 8 2 7 | 6 5 4 3 - poll

    public static Stack<Integer> interLeave(Stack<Integer> stack) {
        Queue<Integer> q = new LinkedList<>();
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        while (!q.isEmpty()) {
            int rotate = q.size() - 1;
            // rotate last to first
            for (int i = 0; i < rotate; i++) {
                q.offer(q.poll());
            }

            stack.push(q.poll());
            if (!q.isEmpty()) {
                stack.push(q.poll());
            }
        }

        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        interLeave(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}