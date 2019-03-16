import java.util.*;

class Main {
    public static int[] smallerRightElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int len = arr.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = len - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek() < arr[i]) {
                res[i] = stack.size();
            
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                res[i] = stack.size();
            
                stack.push(arr[i]);
            }            
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = smallerRightElements(new int[] { 3, 4, 9, 6, 1 });
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}