import java.util.Map;

class Main {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int dist = getDist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
                int val = kv.getValue();
                if (val > 1) {
                    res += (val - 1) * val;
                }
            }
            map.clear();
        }

        return res;
    }

    private int getDist(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return x * dx + dy * dy;
    }
}