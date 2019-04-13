import java.util.*;

class Main {
    public static int removeIntervals(List<int[]> intervals) {
        Collections.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                else
                    return a[0] - b[0];
            }
        });

        int res = 0;
        for (int i = 1; i < intervals.size(); i++) {
            if (isOverlap(intervals.get(i - 1), intervals.get(i))) {
                intervals.remove(i);
                res++;
            }
        }

        return res;
    }

    private static boolean isOverlap(int[] a, int[] b) {
        return (a[0] <= b[0] && a[1] >= b[0] || a[0] <= b[1] && a[1] >= b[1]) ? true : false;
    }

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] { 7, 9 });
        list.add(new int[] { 2, 4 });
        list.add(new int[] { 5, 8 });
        System.out.println(removeIntervals(list));
    }
}