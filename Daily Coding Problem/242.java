import java.util.*;

class Main {
    private BinaryIndexedTree tree;
    private int[] _nums;

    public Main(int[] nums) {
        tree = new BinaryIndexedTree(nums.length);
        _nums = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            tree.update(i + 1, nums[i]);
        }
    }

    public void update(int hour, int value) {
        tree.update(i + 1, value - _nums[i]);
        _num[i] = val;
    }

    public int query(int start, int end) {
        return tree.query(end) - tree.query(start);
    }
}

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