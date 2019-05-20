class BinarySearch {
    public int binarySearch(int[] a, int l, int r, int val) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] == val)
                return m;
            if (a[m] > val) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l; // -1
    }

    public int lowerBound(int[] a, int l, int r, int val) {
        while (l < r) {
            int m = l + (r - l) / 2;
            // first index of i such that a[i] >= x
            if (a[m] >= val) { // g(m)
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int upperBound(int[] a, int l, int r, int val) {
        while (l < r) {
            int m = l + (r - l) / 2;
            // first index of i such that a[i] > x
            if (A[m] > val) { // g(m)
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}