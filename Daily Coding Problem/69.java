class Main {
    public int maxProd(int[] arr, int n) {
        if (n < 3)
            return -1;

        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            if (arr[i] > maxA) {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            } else if (arr[i] > maxB) {
                maxC = maxB;
                maxB = arr[i];
            } else if (arr[i] > maxC) {
                maxC = arr[i];
            }

            if (arr[i] < minA) {
                minB = minA;
                minA = arr[i];
            } else if (arr[i] < minB) {
                minB = arr[i];
            }
        }

        return Math.max(minA * minB * maxA, maxA * maxB * maxC);
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] arr = new int[] { -10, -10, 5, 2 };

        System.out.println(m.maxProd(arr, arr.length));
    }
}