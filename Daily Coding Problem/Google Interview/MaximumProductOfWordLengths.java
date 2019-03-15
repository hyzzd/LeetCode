class Main {
    public static int maxProduct(String[] arr) {
        int[] mask = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int val = 0x0;
            for (char ch : arr[i].toCharArray()) {
                val |= (1 << (ch - 'a'));
            }
            mask[i] = val;
        }
        int res = 0;
        for (int i = 0; i < mask.length - 1; i++) {
            for (int j = i + 1; j < mask.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, arr[i].length() * arr[j].length());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }));
    }
}