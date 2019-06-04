import java.util.*;

class Main {
    public static int minStep(int[] arr, int n) {
        int jumps[] = new int[n]; // jumps[n-1] will hold the
        // result
        int i, j;

        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE; // if first element is 0,
                                      // end cannot be reached

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }

    public static void main(String[] args) {
        int[] arr = { 6, 2, 4, 0, 5, 1, 1, 4, 2, 9 };
        System.out.println(minStep(arr, arr.length));
    }
}