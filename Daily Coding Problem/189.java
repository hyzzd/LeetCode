import java.util.*;

class Main {
    public static int longestSubArray(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int res = 0;
        int anchor = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                res = Math.max(res, i - anchor + 1);
            } else {
                while (anchor <= i && set.contains(arr[i])) {
                    set.remove(arr[anchor++]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 5, 2, 3, 4, 1};
        System.out.println(longestSubArray(arr));
    }
}