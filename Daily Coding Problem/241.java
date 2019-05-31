import java.util.*;

class Main {
    public static int hIndex(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= i) {
                res = i;
                break;
            }
        }

        return res;
    }
}