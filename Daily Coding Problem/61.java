class Main {
    public static int power(int x, int y) {
        int temp = 0;
        if (y == 0)
            return 1;

        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 3));
    }
}