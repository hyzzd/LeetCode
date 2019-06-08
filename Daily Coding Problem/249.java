import java.util.*;

class Main {
    public static int maxXOR(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[i] ^ arr[j]);
            }
        }

        return max;
    }
}