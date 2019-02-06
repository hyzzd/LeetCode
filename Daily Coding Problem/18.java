import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public int[] maxVal(int[] arr, int k) {
        PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(Collections.reverseOrder());
        int max = 0;
        int[] result = new int[arr.length - k + 1];

        int i = 0;
        while (pQ.size() < k) {
            pQ.add(arr[i]);
            i++;
        }
        result[0] = pQ.peek();

        for (i = k; i < arr.length; ++i) {
            pQ.remove(arr[i - k]);
            pQ.add(arr[i]);
            result[i - k + 1] = pQ.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] arr = { 2, 3, 10, 5, 2, 7, 8, 7 }; // {10, 5, 2, 7, 8, 7};
        int[] result = m.maxVal(arr, 3);

        for (int i : result) {
            System.out.println(i);
        }
        System.out.println("Hello World!");
    }
}