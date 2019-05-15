class Main {
    public static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }

    public static int josephus2(int n) {
        /*
         * If n is power of 2, answer is 1 Otherwise answer is 2 * p + 1; where p = n - m ,
         * where m is highest power of 2 less than n.
         */
        return 2 * (n - Integer.highestOneBit(n)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(josephus(5, 2));
    }
}