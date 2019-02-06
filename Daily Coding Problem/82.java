class Main {
    public int read(char[] buf, int n) {
        boolean eof = false;
        int total = 0;
        char[] tmp = new char[7];

        while (!eof && total < n) {
            int count = read7(tmp);

            eof = count < 7;

            count = Math.min(count, n - total);

            for (int i = 0; i < count; ++i) {
                buf[total++] = tmp[i];
            }
        }

        return total;
    }

    private int read7(char[] tmp) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}