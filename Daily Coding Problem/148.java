class Main {
    // The idea is simple. G(i) = i ^ (i/2).
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++)
            result.add(i ^ i >> 1);
        return result;
    }

    // public List<Integer> grayCode(int n) {
    // if (n == 0) {
    // List<Integer> list = new ArrayList<Integer>();
    // list.add(0);
    // return list;
    // }
    // List<Integer> pre = grayCode(n - 1);
    // List<Integer> cur = new ArrayList<Integer>(pre);
    // int add = (int) Math.pow(2, n - 1);
    // for (int i = pre.size() - 1; i >= 0; i--) {
    // cur.add(pre.get(i) + add);
    // }
    // return cur;
    // }
}