class Main {
    public static double sqrRoot(double n) {
        double l = 0;
        double r = n;
        while (l < r) {
            double m = l + (r - l) / 2;
            if (m * m < n) {
                l = m;
            } else if (m * m > n) {
                r = m;
            } else {
                return m;
            }
        }

        return l;
    }

    public static void main(String args[]) {
        System.out.print(sqrRoot(9.1));
    }
}