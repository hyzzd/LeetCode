class Main {
    public int maxSum(int[] arr) {
        int[] sum = new int[arr.length + 1];

        int temp = 0;
        sum[0] = 0;
        for (int i = 1; i <= arr.length; ++i) {
            temp += arr[i - 1];
            sum[i] = temp;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; ++i) {
            if (max < sum[i])
                max = sum[i];
            if (min > sum[i])
                min = sum[i];
        }

        return max - min;
    }

    public static void main(String[] args) {
        Main m = new Main();

        System.out.println(m.maxSum(new int[] { 34, -50, 42, 14, -5, 86 }));
    }
}