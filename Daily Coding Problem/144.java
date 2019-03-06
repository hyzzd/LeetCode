class Main {
    public static int nearestLarger(int[] arr, int idx) {
        int l = 0, r = 0;
        while (idx - l >= 0 && arr[idx - l] <= arr[idx]) {
            l++;
        }
        while (idx + r < arr.length && arr[idx + r] <= arr[idx]) {
            r++;
        }
        if (idx - l >= 0 && idx + r < arr.length) {
            return Math.min(l, r);
        } else if (idx - l >= 0) {
            return l;
        } else {
            return r;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 5, 6 };
        System.out.println(nearestLarger(arr, 0));
    }
}