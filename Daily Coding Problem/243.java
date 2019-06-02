import java.util.*;

class Main {
    public static int partitionArr(int[] arr, int k) { // n > k
        if (k == 1)
            return sum(arr, 0, arr.length);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum1 = sum(arr, 0, i + 1);
            int sum2 = partitionArr(Arrays.copyOfRange(arr, i + 1, arr.length), k - 1);
            int curMax = Math.max(sum1, sum2);
            if (curMax < min) min = curMax;
        }

        return min;
    }

    public static int sum(int[] arr, int i, int j) {
        int res = 0;
        for (int k = i; k < j; k++)
            res += arr[k];
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 7, 3, 4};
        System.out.println(partitionArr(arr, 3));
    }
}