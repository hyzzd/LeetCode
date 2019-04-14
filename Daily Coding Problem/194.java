import java.util.*;

class Main {
    public int numOfIntersection(List<int[]> points) {
        // intersect happens when p1 < p2 && q1 > q2 or reverse
        int res = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                res += isIntersect(points.get(i), points.get(j));
            }
        }

        return res;
    }

    private int isIntersect(int[] a, int[] b) {
        return (a[0] < b[0] && a[1] > b[1]) || (a[0] > b[0] && a[1] < b[1]) ? 1 : 0;
    }
}