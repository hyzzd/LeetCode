class Main {
    static int shortestPath(Point p1, Point p2) {
        int dx = Math.abs(p1.x - p2.x);
        int dy = Math.abs(p1.y - p2.y);

        return Math.max(dx, dy);
    }

    static int coverPoints(Point[] arr, int n) {
        int result = 0;
        for (int i = 1; i < n; ++i) {
            result += shortestPath(arr[i - 1], arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Point arr[] = new Point[4];
        arr[0] = new Point(4, 6);
        arr[1] = new Point(1, 2);
        arr[2] = new Point(4, 5);
        arr[3] = new Point(10, 12);

        int n = arr.length;
        System.out.print(coverPoints(arr, n));
    }
}

class Point {
    int x, y;

    Point(int a, int b) {
        x = a;
        y = b;
    }
}