class Main {
    private int[] cumSum;
    private int[] L;

    public Main(int[] arr) {
        L = arr;
        cumSum = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            cumSum[i] = sum;
        }
    }

    public int sum(int i, int j) {
        return cumSum[j - 1] - (i - 1) > -1 ? cumSum[i - 1] : 0;
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Main m = new Main(arr);
        System.out.print(m.sum(1, 3));
    }
}