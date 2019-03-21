class Main {
    char[][] pairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };
    int count = 0;

    public int strobogrammaticInRange(String low, String high) {
        for (int i = low.length(); i <= high.length(); i++) {
            dfs(low, high, new char[i], 0, i - 1);
        }
        return count;
    }

    private void dfs(String low, String high, char[] c, int left, int right) {
        if (left > right) {
            String s = new String(c);
            if (s.length() == low.length() && s.compareTo(low) < 0
                    || s.length() == high.length() && s.compareTo(high) > 0) {
                return;
            }
            count++;
            return;
        }

        for (char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if (chs.length != 1 && c[left] == '0')
                continue;
            if (left < right || left == right && c[left] == c[right]) {
                dfs(low, high, c, left + 1, right - 1);
            }
        }
    }
}