class Main {
    public static long divide(long dividend, long divisor) {
        long sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        long quotient = 0, temp = 0;

        for (int i = 31; i >= 0; --i) {
            if (temp + (divisor << i) <= dividend) {
                temp += divisor << i;
                quotient |= 1L << i;
            }
        }

        return (sign * quotient);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}