class BinarySearch {
    public int binarySearch(int[] arr, int l, int r, int val) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] == val)
                return m;
            if (arr[m] > val) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}