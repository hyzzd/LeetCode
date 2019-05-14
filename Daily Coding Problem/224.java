class Main {
    public static int sortedSmallest(int[] arr) {
        int res = 1;
        for (int a : arr) {
            if (a > res)
                break;
            res += a;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sortedSmallest(new int[] { 1, 2, 3, 4, 10 }));
    }
}