import java.util.Random;

class Main {
    public double estimatePi() {
        int low = -1000;
        int high = 1000;
        int count = 0;
        int total = 1000000;

        for (int i = 0; i < total; ++i) {
            Random x = new Random();
            Random y = new Random();
            double xVal = 0.001 * (x.nextInt(high - low) + low);
            double yVal = 0.001 * (y.nextInt(high - low) + low);

            if (inArea(xVal, yVal)) {
                count++;
            }
        }

        return 4.0 * count / total;
    }

    private boolean inArea(double xVal, double yVal) {
        return (xVal * xVal + yVal * yVal) <= 1;
    }

    public static void main(String[] args) {
        Main m = new Main();
        double input = m.estimatePi();
        System.out.println(String.format("%.3f", input));
    }
}