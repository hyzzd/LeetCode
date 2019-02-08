class Main {
    public static int expectedRnd(int n) {
        int count = 0;
        while (n > 1) {
            int left = 0;
            for (int i = 0; i < n; i++) {
                count++;
                if (Math.random() > 0.5) {
                    // Tails
                    left++;
                }
            }
            n = left;
        }

        return count;
    }

    public static void main(String args[]) {
        System.out.println(expectedRnd(10));
    }
}