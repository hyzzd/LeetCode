class Main {
    public static int area(int[][] a, int[][] b) {
        // int aTLx = a[0][0];
        // int aTLy = a[0][1];
        // int aTRx = a[0][0] + a[1][0];
        // int aTRy = a[0][1];
        // int aDLx = a[0][0];
        // int aDLy = a[0][1] - a[1][1];
        // int aDRx = a[0][0] + a[1][0];
        // int aDRy = a[0][1] - a[1][1];
        int x1 = Math.max(a[0][0], b[0][0]);
        int x2 = Math.min(a[0][0] + a[1][0], b[0][0] + b[1][0]);
        if (x1 > x2) {
            return -1;
        }
        int y1 = Math.min(a[0][1], b[0][1]);
        int y2 = Math.max(a[0][1] - a[1][1], b[0][1] - b[1][1]);
        if (y1 < y2) {
            return -1;
        }
        return (x2 - x1) * (y1 - y2);
    }

    public static void main(String[] args) {
        System.out.println(area(new int[][] { { 1, 4 }, { 3, 3 } }, new int[][] { { 0, 5 }, { 4, 3 } }));
    }
}