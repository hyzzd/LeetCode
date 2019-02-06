class Main {
    public int interval(int[] arr1, int[] arr2) {
        int result = 0;
        int n = arr1.length;
        // arr1 < arr2
        for (int i = 1; i < n; ++i) {
            if (arr1[i] < arr2[i - 1]) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.interval(new int[] { 0, 30, 60 }, new int[] { 50, 75, 150 }));
    }
}