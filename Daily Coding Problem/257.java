class Main {
    public static int[] sortWindow(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, arr[i]);
            }
        }
        flag = false;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, arr[i]);
            }
        }
        int l, r;
        for (l = 0; l < arr.length; i++) {
            if (min < arr[l]) {
                break;
            }
        }
        for (r = arr.length - 1; r >= 0; r--) {
            if (max > arr[r]) {
                break;
            }
        }
        return new int[] { l, r };
    }
}