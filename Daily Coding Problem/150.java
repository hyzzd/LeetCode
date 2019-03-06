class Main {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public List<Point> closest(List<Point> points, int k) {
        List<Point> result = new ArrayList<>();
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                double d1 = getDistance(p1);
                double d2 = getDistance(p2);

                if (d1 == d2) {
                    return 0;
                }

                return d1 < d2 ? 1 : -1;
            }
        });

        // Traverse all the points in the list and find out the ones
        for (int i = 0; i < points.size(); i++) {
            if (i < k) {
                maxHeap.offer(points.get(i));
            } else if (getDistance(points.get(i)) < getDistance(maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.offer(points.get(i));
            }
        }

        for (Point p : maxHeap) {
            result.add(p);
        }

        return result;
    }

    private double getDistance(Point p) {
        return Math.sqrt(p.x * p.x + p.y * p.y);
    }
}