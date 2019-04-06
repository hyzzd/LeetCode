class Main {
    public static int greatestComDenom(int[] arr) {
        int curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr = comDenom(curr, arr[i]);
        }

        return curr;
    }

    private static int comDenom(int a, int b) {
        while (a % b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }

        return b;
    }

    public static void main(String[] args) {
        int[] arr = { 42, 56, 14, 70 };
        System.out.println(greatestComDenom(arr));
    }
}