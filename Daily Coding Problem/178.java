class Main {
    public static int game1() {
        int prev = -1;
        int sum = 0;
        while (true) {
            int curr = (int) (Math.random() * 6) + 1;
            sum++;
            if (prev == 5 && curr == 6) {
                return sum;
            }
            prev = curr;
        }
    }

    public static int game2() {
        int prev = -1;
        int sum = 0;
        while (true) {
            int curr = (int) (Math.random() * 6) + 1;
            sum++;
            if (prev == 5 && curr == 5) {
                return sum;
            }
            prev = curr;
        }
    }

    public static void main(String[] args) {
        int i = 10;
        int sum1 = 0, sum2 = 0;
        while (i-- > 0) {
            sum1 += game1();
        }
        i = 10;
        while (i-- > 0) {
            sum2 += game2();
        }

        System.out.print(sum1 + " " + sum2);
    }
}