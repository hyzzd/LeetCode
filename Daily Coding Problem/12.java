class Main {
    Count c = new Count();

    public void climbStair(int[] arr, int n, Count c) {
        if (n == 0) {
            c.count++;
            return;
        }
        if (n < 0) {
            return;
        }
        for (int i : arr) {
            climbStair(arr, n - i, c);
        }
    }

    public int countStair(int[] arr, int n) {
        climbStair(arr, n, c);
        return c.count;
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        System.out.println(m1.countStair(new int[] { 1, 2 }, 4));
        Main m2 = new Main();
        System.out.println(m2.countStair(new int[] { 1, 3, 5 }, 4));
    }
}

class Count {
    int count = 0;
}
