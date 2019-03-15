class Main {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (citations == null || len == 0)
            return 0;
        int[] counts = new int[len + 1];
        for (int c : citations) {
            if (c > len)
                counts[len]++;
            else
                counts[c]++;
        }
        if (counts[len] >= len)
            return len;
        for (int i = len - 1; i >= 0; i--) {
            counts[i] += counts[i + 1];
            if (counts[i] >= i)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] nums = new int[] { 1, 2, 3, 4 };

        System.out.print(m.hIndex(nums));
    }
}