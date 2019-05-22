class SegmentTree {
    // balanced binary tree
    // each leaf rep an element, each non leaf covers union of children
    class Node {
        int start;
        int end;
        int sum;
        Node left, right;

        public Node(int s, int e, int su) {
            start = s;
            end = e;
            sum = su;
        }

        public Node(int s, int e, int su, Node l, Node r) {
            start = s;
            end = e;
            sum = su;
            left = l;
            right = r;
        }
    }

    public Node buildTree(int start, int end, int[] vals) { // O(n)
        if (start == end)
            return new Node(start, end, vals[start]);
        int mid = (start + end) / 2;
        Node left = buildTree(start, mid, vals);
        Node right = buildTree(mid + 1, end, vals);
        return new Node(start, end, left.sum + right.sum, left, right);
    }

    public void updateTree(Node root, int index, int val) {
        if (root.start == root.end && root.end == index) {
            root.sum = val;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index < mid) {
            updateTree(root.left, index, val);
        } else {
            updateTree(root.right, index, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int query(Node root, int i, int j) { // log(n) + k
        if (root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        if (j <= mid) {
            return query(root.left, i, j);
        } else if (i > mid) {
            return query(root.right, i, j);
        }

        return query(root.left, i, mid) + query(root.right, mid + 1, j);
    }
}