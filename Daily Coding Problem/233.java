class Main {
    public static int fib(int n) {
        if (n <= 0)
            return -1;
        if (n == 1 || n == 2)
            return 1;

        int dp1 = 1;
        int dp2 = 1;
        for (int i = 3; i <= n; i++) {
            int t = dp2;
            dp2 = dp1 + dp2;
            dp1 = t;
        }

        return dp2;
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fib(5));
        System.out.println(fib(10));
    }
}