// Fenwick Tree query O(logn) update O(logn)
class BinaryIndexedTree {
    private int[] sum;

    public BinaryIndexedTree(int n) {
        sum = new int[n + 1];
    }

    public void update(int i, int delta) {
        while (i < sum.length) {
            sum[i] += delta;
            i += lowbit(i);
        }
    }

    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += sum[i];
            i -= lowbit(i);
        }
        return res;
    }

    private int lowbit(int x) {
        return x & (-x);
    }
}