class Main {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findMedian(A, 0, B, 0, len / 2 + 1);
        } else {
            return (findMedian(A, 0, B, 0, len / 2) + findMedian(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }
    }

    private int findMedian(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
        if (A_key < B_key) {
            return findMedian(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findMedian(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }

    public static void main(String args[]) {
        Main m = new Main();
        int[] a = new int[] { 1, 2 };
        int[] b = new int[] { 3, 4 };
        System.out.print(m.findMedianSortedArrays(a, b));
    }
}